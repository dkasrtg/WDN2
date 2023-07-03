package etu1995.framework.servlet;

import annotations.Authentication;
import annotations.MappingUrl;
import annotations.Scope;
import annotations.Session;
import com.google.gson.Gson;
import etu1995.framework.Mapping;
import etu1995.framework.ModelView;

import etu1995.framework.error.Error;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import utilities.*;


@MultipartConfig
public class FrontServlet extends HttpServlet{
    HashMap<String, Mapping> MappingUrls;
    HashMap<String, Object> Singletons;
    String authentication;
    String session;
    Reflection reflection;
    String pages;
    String context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            setReflection(new Reflection());
            setSingletons(new HashMap<>());
            setMappingUrls(new HashMap<>(),getInitParameter("path"));
            setAuthentication(getInitParameter("authentication"));
            setSession(getInitParameter("session"));
            setPages(getInitParameter("pages"));
            setContext(getServletContext().getContextPath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return pages;
    }

    public void setReflection(Reflection reflection) {
        this.reflection = reflection;
    }

    public Reflection getReflection() {
        return reflection;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String url = req.getRequestURL().toString();
        String last = url.substring(url.lastIndexOf(getContext())+getContext().length()+1);
        if (getMappingUrls().containsKey(last)){
            Mapping tmp = getMappingUrls().get(last);
            Class<?> cls = Class.forName(tmp.getClassName());
            Object c = instantiate(cls);
            Method m = getReflection().method_by(tmp.getMethod(),c);
            boolean auth = authenticator(m,req);
            if (!auth){
                writer(resp, Error.fourzerothree());
                return;
            }
            session_giver(m,c,req);
            HashMap<String,String> p = parameters(req);
            HashMap<String,Vector<Part>> part = parts(req);
            setClass(p,part,c);
            Parameter[] parameters = m.getParameters();
            Object[] obj =  new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                if (p.containsKey(parameters[i].getName())){
                    obj[i] = getReflection().caster(parameters[i].getType().getName()).invoke(getReflection(),p.get(parameters[i].getName()));
                } else if (part.containsKey(parameters[i].getName())) {
                    obj[i] = getReflection().caster(parameters[i].getType().getName()).invoke(getReflection(),part.get(parameters[i].getName()));
                } else {
                    obj[i] = null;
                }
            }
            if (m.getReturnType() == ModelView.class){
                ModelView modelView = null;
                try {
                    modelView = (ModelView) m.invoke(c,obj);
                }catch (Exception e){
                    writer(resp,Error.error(e));
                    return;
                }
                modelView.getData().forEach(
                        (key,value)
                                -> req.setAttribute(key,value)
                );
                session_setter(modelView.getSession(),req);
                if (modelView.getInvalidateSession()){
                    kill_all_sessions(req);
                }
                kill_sessions(modelView.getRemoveSessions(),req);
                if (modelView.getJson()){
                    json(resp,modelView.getData());
                    return;
                }
                String page = "./pages/"+modelView.getView();
                if (getServletContext().getResource(page)==null) {
                    writer(resp, Error.fourzerofourfile(page));
                    return;
                }
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
                requestDispatcher.forward(req,resp);
            }
            else {
                if (m.getReturnType()!=Void.TYPE){
                    Object o = null;
                    try {
                        o = m.invoke(c,obj);
                    }catch (Exception e){
                        Error.error(e);
                    }
                    json(resp,o);
                    return;
                }
                try {
                    m.invoke(c, obj);
                }catch (Exception e){
                    Error.error(e);
                }
            }
        }
        else {
            writer(resp,Error.fourzerofour());
        }
    }

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls,String pat) throws Exception {
        MappingUrls = mappingUrls;
        List<File> files = new ArrayList<>();
        get_files(pat,files);
        int ind = pat.lastIndexOf("\\");
        String pack = pat.substring(ind+1);
        for (File p :files){
            String path = p.getAbsolutePath();
            path = path.split(pack)[1];
            path = pack +path;
            path = path.replaceAll(".class","");
            path = path.replace("\\",".");
            Class<?> cls = Class.forName(path);
            for (Method m : cls.getDeclaredMethods()){
                if (m.isAnnotationPresent(MappingUrl.class)){
                    getMappingUrls().put(m.getAnnotation(MappingUrl.class).url(),new Mapping(path,m.getName()));
                }
            }
            if (cls.isAnnotationPresent(Scope.class)){
                Scope scope = cls.getAnnotation(Scope.class);
                if (Objects.equals(scope.type(), "singleton")) {
                    getSingletons().put(path, null);
                }
            }
        }
    }
    public HashMap<String,String> parameters(HttpServletRequest request) throws Exception {
        HashMap<String,String> result = new HashMap<>();
        Enumeration<String> parameters = request.getParameterNames();
        while (parameters.hasMoreElements()){
            String pname = parameters.nextElement();
            if(pname.endsWith("[]")){
                String coco = pname.substring(0,pname.indexOf('['));
                result.put(coco, Arrays.toString(request.getParameterValues(pname)));
            }
            else {
                result.put(pname, request.getParameter(pname));
            }
        }
        return result;
    }
    public HashMap<String,Vector<Part>> parts(HttpServletRequest request) {
        HashMap<String,Vector<Part>> result = new HashMap<>();
        Collection<Part> parts = null;
        try {
            parts = request.getParts();
        } catch (Exception e) {
            return result;
        }
        Iterator<Part> partIterator = parts.iterator();
        while (partIterator.hasNext()){
            Part p = partIterator.next();
            if (result.containsKey(p.getName())){
                result.get(p.getName()).add(p);
            }
            else {
                Vector<Part> tmp = new Vector<>();
                tmp.add(p);
                result.put(p.getName(),tmp);
            }
        }
        return result;
    }

    public void get_files(String path, List<File> files){
        File f = new File(path);
        File[] list = f.listFiles();
        if (list!=null){
            for (File file: list){
                if (file.isFile()){
                    files.add(file);
                }
                else if (file.isDirectory()){
                    get_files(file.getAbsolutePath(),files);
                }
            }
        }
    }
    public void setClass(HashMap<String,String> p,HashMap<String,Vector<Part>> parts,Object c){
        p.forEach(
                (key,value)
                        -> {
                    String to_compare = "set";
                    to_compare = to_compare + key;
                    for (int j = 0; j < c.getClass().getDeclaredMethods().length; j++) {
                        if (c.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
                            Method method = c.getClass().getDeclaredMethods()[j];
                            String name =  method.getParameterTypes()[0].getName();
                            if (name.equals("java.lang.String")){
                                try {
                                    method.invoke(c,value);
                                }
                                catch (Exception ignored){}
                            }
                            else {
                                try {
                                    method.invoke(c,getReflection().caster(name).invoke(getReflection(),value));
                                }
                                catch (Exception ignored){}
                            }
                        }
                    }
                }
        );
        parts.forEach(
                (key,value)
                        -> {
                    String to_compare = "set";
                    to_compare = to_compare + key;
                    for (int j = 0; j < c.getClass().getDeclaredMethods().length; j++) {
                        if (c.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
                            Method method = c.getClass().getDeclaredMethods()[j];
                            String name =  method.getParameterTypes()[0].getName();
                            try {
                                method.invoke(c,getReflection().caster(name).invoke(getReflection(),value));
                            } catch (Exception ignored) { }
                        }
                        }
                    }
        );
    }

    public HashMap<String, Object> getSingletons() {
        return Singletons;
    }

    public void setSingletons(HashMap<String, Object> singletons) {
        Singletons = singletons;
    }

    public Object instantiate(Class<?> cls) throws Exception {
        String name = cls.getCanonicalName();
        if(getSingletons().containsKey(name)){
            if (getSingletons().get(name)!=null) {
                getReflection().nullos(getSingletons().get(name));
            }
            else {
                getSingletons().replace(name,cls.newInstance());
            }
            return getSingletons().get(name);
        }
        return cls.newInstance();
    }

    public void session_setter(HashMap<String,Object> session,HttpServletRequest request){
        session.forEach(
                (key,value) -> {
                    request.getSession().setAttribute(key,value);
        }
        );
    }

    public boolean authenticator(Method method,HttpServletRequest request){
        if (method.isAnnotationPresent(Authentication.class)){
            Authentication authentication = method.getAnnotation(Authentication.class);
            String users = authentication.users();
            if (Objects.equals(users, "")){
                return true;
            }
            else {
                String[] valid = users.split(",");
                String auth = (String) request.getSession().getAttribute(getAuthentication());
                for (int i = 0; i < valid.length; i++) {
                    if (Objects.equals(valid[i], auth)){
                        return true;
                    }
                }
            }
        }
        else {
            return true;
        }
        return false;
    }

    public void writer(HttpServletResponse response,String content) throws Exception {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(content);
    }

    public void json(HttpServletResponse response,Object o) throws Exception {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String rs = new Gson().toJson(o);
        out.println("<html>");
        out.println(rs);
        out.println("</html>");
    }

    public void session_giver(Method m,Object c,HttpServletRequest request) throws Exception {
        if (m.isAnnotationPresent(Session.class)){
            String to_compare = "set"+getSession();
            for (int j = 0; j < c.getClass().getDeclaredMethods().length; j++) {
                if (c.getClass().getDeclaredMethods()[j].getName().equalsIgnoreCase(to_compare)) {
                    Method method = c.getClass().getDeclaredMethods()[j];
                    HashMap<String,Object> map = new HashMap<>();
                    Enumeration<String> attributes = request.getSession().getAttributeNames();
                    while (attributes.hasMoreElements()) {
                        String attribute = (String) attributes.nextElement();
                        map.put(attribute,request.getSession().getAttribute(attribute));
                    }
                    method.invoke(c,map);
                    return;
                }
            }
        }
    }

    public void kill_all_sessions(HttpServletRequest request){
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            request.getSession().removeAttribute(enumeration.nextElement());
        }
    }

    public void kill_sessions(Vector<String> strings,HttpServletRequest request){
        for (int i = 0; i < strings.size(); i++) {
            request.getSession().removeAttribute(strings.get(i));
        }
    }
}