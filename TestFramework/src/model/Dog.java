package model;

import annotations.MappingUrl;
import etu1995.framework.ModelView;

import java.util.HashMap;

public class Dog {
    String name;

    int age;

    public Dog(){

    }

    public Dog(String name,int age) {
        setName(name);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @MappingUrl(url = "dog-all")
    public ModelView findAll(){
        ModelView modelView = new ModelView("dog.jsp");
        modelView.addItem("dogs",new String[]{"Q","W","R"});
        modelView.addItem("alik",new Dog("Alik",20));
        return modelView;
    }

    @MappingUrl(url = "dog-dogger")
    public void dogme(){
        System.out.println(getName());
        System.out.println(getAge());
    }

}
