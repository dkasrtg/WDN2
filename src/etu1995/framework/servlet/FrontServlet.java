package etu1995.framework.servlet;

import annotations.MappingUrl;
import etu1995.framework.Mapping;
import org.apache.commons.io.FileUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

public class FrontServlet extends HttpServlet{
    HashMap<String, Mapping> MappingUrls;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            setMappingUrls(new HashMap<>());
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
        if(!req.getQueryString().isEmpty()){
            url = url + "?" + req.getQueryString();
        }
        req.setAttribute("url",url);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontservlet.jsp");
        requestDispatcher.forward(req,resp);
    }

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) throws Exception {
        MappingUrls = mappingUrls;
        File f = new File(getServletContext().getRealPath("/strs.properties").replaceAll("strs.properties",""));
        Collection<File> files = FileUtils.listFiles(f,new String[]{"class"},true);
        for (File p :files){
            String path = p.getAbsolutePath();
            path = path.split("classes")[1];
            path = path.substring(path.indexOf('\\')+1);
            path = path.replace('\\','.');
            path = path.replaceAll(".class","");
            Class<?> cls = Class.forName(path);
            for (Method m : cls.getDeclaredMethods()){
                if (m.isAnnotationPresent(MappingUrl.class)){
                    getMappingUrls().put(path+"-"+m.getAnnotation(MappingUrl.class).url(),new Mapping(path,m.getName()));
                }
            }
        }
    }
}
