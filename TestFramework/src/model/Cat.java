package model;

import annotations.MappingUrl;
import etu1995.framework.ModelView;

public class Cat {
    String name;

    public Cat() {
    }

    public Cat(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @MappingUrl(url = "cat-all")
    public ModelView findAll(){

        return new ModelView("cat.jsp");
    }
}
