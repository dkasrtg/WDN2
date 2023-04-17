package model;

import annotations.MappingUrl;
import etu1995.framework.ModelView;

import java.util.HashMap;

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

    @MappingUrl(url = "cat-catter")
    public void catme(HashMap<String,String> parameters){
        System.out.println("Catter");
        parameters.forEach(
                (key,value)
                        -> System.out.println(key + " : " + value)
        );
    }
}
