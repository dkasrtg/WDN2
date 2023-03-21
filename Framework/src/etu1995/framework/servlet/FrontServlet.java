package etu1995.framework.servlet;

import annotations.MappingUrl;
import etu1995.framework.Mapping;
import org.apache.commons.io.FileUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;

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
        try {
            if (!req.getQueryString().isEmpty()) {
                url = url + "?" + req.getQueryString();
            }
        }catch (Exception ignored){}
        System.out.println(url);
        Enumeration<String> parameters = req.getParameterNames();
        System.out.println("Parameters:");
        while (parameters.hasMoreElements()){
            String pname = parameters.nextElement();
            System.out.println(pname+": "+req.getParameter(pname));
        }
    }


    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls,String pat) throws Exception {
        MappingUrls = mappingUrls;
        File f = new File("C:\\xampp\\tomcat\\webapps\\WDN2\\src\\types");
        Collection<File> files = FileUtils.listFiles(f,new String[]{"java"},true);
        int ind = f.getAbsolutePath().lastIndexOf("\\");
        String pack = f.getAbsolutePath().substring(ind+1);
        for (File p :files){
            String path = p.getAbsolutePath();
            path = path.split(pack)[1];
            path = pack +path;
            path = path.replaceAll(".java","");
            path = path.replace("\\",".");
            Class<?> cls = Class.forName(path);
            for (Method m : cls.getDeclaredMethods()){
                if (m.isAnnotationPresent(MappingUrl.class)){
                    getMappingUrls().put(path+"-"+m.getAnnotation(MappingUrl.class).url(),new Mapping(path,m.getName()));
                }
            }
        }
    }
}
