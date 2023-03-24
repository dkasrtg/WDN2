package model;

import annotations.MappingUrl;
import etu1995.framework.ModelView;

public class Dog {
    String name;

    public Dog(){

    }

    public Dog(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @MappingUrl(url = "dog-all")
    public ModelView findAll(){
        return new ModelView("dog.jsp");
    }
}
