package etu1995.framework.servlet;

import annotations.MappingUrl;
import etu1995.framework.Mapping;
import etu1995.framework.ModelView;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import utilities.*;

public class FrontServlet extends HttpServlet{
    HashMap<String, Mapping> MappingUrls;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            setMappingUrls(new HashMap<>(),getInitParameter("path"));
            System.out.println(getMappingUrls());
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

    public void processRequest(HttpServletRequest req,HttpServletResponse resp) throws Exception {
        String url = req.getRequestURL().toString();
        int lst = url.lastIndexOf('/');
        String last = url.substring(lst+1);
//        System.out.println(last);
        try {
            if (!req.getQueryString().isEmpty()) {
                url = url + "?" + req.getQueryString();
            }
        }catch (Exception ignored){}
//        System.out.println(url);
//        Enumeration<String> parameters = req.getParameterNames();
//        System.out.println("Parameters:");
//        while (parameters.hasMoreElements()){
//            String pname = parameters.nextElement();
//            System.out.println(pname+": "+req.getParameter(pname));
//        }
        if (getMappingUrls().containsKey(last)){
            Mapping tmp = getMappingUrls().get(last);
            Class<?> cls = Class.forName(tmp.getClassName());
            Method m = cls.getDeclaredMethod(tmp.getMethod());
            if (m.getReturnType() == ModelView.class){
                ModelView modelView = (ModelView) m.invoke(cls.newInstance());
                modelView.getData().forEach(
                        (key,value)
                        -> req.setAttribute(key,value)
                );
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(modelView.getView());
                requestDispatcher.forward(req,resp);
            }
            else {
                Object c = cls.newInstance();
                HashMap<String,String> p = parameters(req);
                setClass(p,c);
                m.invoke(c);
            }
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
        }
    }
    public HashMap<String,String> parameters(HttpServletRequest request){
        HashMap<String,String> result = new HashMap<>();
        Enumeration<String> parameters = request.getParameterNames();
        while (parameters.hasMoreElements()){
            String pname = parameters.nextElement();
            result.put(pname,request.getParameter(pname));
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
    public void setClass(HashMap<String,String> p,Object c){
        Reflection reflection = new Reflection();
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
                                    method.invoke(c,reflection.caster(name).invoke(reflection,value));
                                }
                                catch (Exception ignored){}
                            }
                        }
                    }
                }
        );
    }
}
