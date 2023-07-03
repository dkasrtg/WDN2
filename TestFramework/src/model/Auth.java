package model;

import annotations.MappingUrl;
import annotations.Authentication;
import etu1995.framework.ModelView;

public class Auth {
    public Auth(){

    }

    @MappingUrl(url = "auth_1.do")
    @Authentication(users = "admin")
    public ModelView auth1(){
        ModelView modelView = new ModelView("auth.jsp");
        modelView.addItem("auth","Accessible for admin");
        return modelView;
    }

    @MappingUrl(url = "auth_2.do")
    @Authentication(users = "admin,manager")
    public ModelView auth2(){
        ModelView modelView = new ModelView("auth.jsp");
        modelView.addItem("auth","Accessible for admin and manager");
        return modelView;
    }

    @MappingUrl(url = "auth_3.do")
    public ModelView auth3(){
        ModelView modelView = new ModelView("auth.jsp");
        modelView.addItem("auth","Accessible for everyone");
        return modelView;
    }
}