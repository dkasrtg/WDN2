package model;

import annotations.MappingUrl;
import annotations.Scope;
import etu1995.framework.ModelView;

import java.util.Objects;

public class Login {
    public Login(){

    }

    @MappingUrl(url = "input_login")
    public ModelView input_login(){
        ModelView modelView = new ModelView("login.jsp");
        modelView.addItem("status"," ");
        return modelView;
    }

    @MappingUrl(url = "treat_login")
    public ModelView treat_login(String name,String password){
        String page = "logged.jsp";
        ModelView modelView = new ModelView(page);
        if (Objects.equals(name, "admin") && Objects.equals(password, "admin")){
            modelView.addSession("is_connected","admin");
        }
        else if (Objects.equals(name, "manag") && Objects.equals(password, "manag")){
            modelView.addSession("is_connected","manager");
        }
        else {
            if (Objects.equals(name, "simple") && Objects.equals(password, "simple")){
                modelView.addSession("is_connected","simple");
            }
            else {
                modelView.setView("login.jsp");
                modelView.addItem("status","Login failed");
            }
        }
        return modelView;
    }
}
