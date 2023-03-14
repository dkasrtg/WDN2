package etu1995.framework.servlet;

import etu1995.framework.Mapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FrontServlet extends HttpServlet{
    HashMap<String, Mapping> MappingUrls;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
    public void processRequest(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if(!req.getQueryString().isEmpty()){
            url = url + "?" + req.getQueryString();
        }
        req.setAttribute("url",url);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("frontservlet.jsp");
        requestDispatcher.forward(req,resp);
    }
}
