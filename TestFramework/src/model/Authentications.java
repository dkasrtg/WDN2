package model;

import annotations.Authentication;
import annotations.MappingUrl;
import etu1995.framework.ModelView;

public class Authentications {

    public Authentications(){

    }

    @MappingUrl(url = "authentication.do")
    public ModelView Main(){
        ModelView modelView = new ModelView("authentication.jsp");
        return modelView;
    }

    @MappingUrl(url = "auth1.do")
    public ModelView Auth1(){
        ModelView modelView = new ModelView("authentications/auth1.jsp");
        return modelView;
    }

    @MappingUrl(url = "auth2.do")
    @Authentication
    public ModelView Auth2(){
        ModelView modelView = new ModelView("authentications/auth2.jsp");
        return modelView;
    }

    @MappingUrl(url = "auth3.do")
    @Authentication(users = "admin")
    public ModelView Auth3(){
        ModelView modelView = new ModelView("authentications/auth3.jsp");
        return modelView;
    }

    @MappingUrl(url = "auth4.do")
    @Authentication(users = "admin,manager")
    public ModelView Auth4(){
        ModelView modelView = new ModelView("authentications/auth4.jsp");
        return modelView;
    }
}
