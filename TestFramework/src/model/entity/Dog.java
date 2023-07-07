package model.entity;

import annotations.Scope;

@Scope(type = "singleton")
public class Dog {

    String name;
    int age;
    boolean is_pro;

    public Dog(){

    }

    public Dog(String name,Integer age){
        setAge(age);
        setName(name);
    }

    public Dog(String name,int age,boolean is_pro) {
        setName(name);
        setAge(age);
        setIs_pro(is_pro);
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

    public void setIs_pro(boolean is_pro) {
        this.is_pro = is_pro;
    }

    public boolean getIs_pro() {
        return is_pro;
    }
}
