package model;

import annotations.MappingUrl;
import annotations.Scope;
import etu1995.framework.ModelView;

@Scope(type = "singleton")
public class Dog {
    String name;

    int age;

    boolean is_pro;


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

    public void setIs_pro(boolean is_pro) {
        this.is_pro = is_pro;
    }

    public boolean getIs_pro() {
        return is_pro;
    }

    @MappingUrl(url = "dog-all")
    public ModelView findAll(Integer length){
        ModelView modelView = new ModelView("dog.jsp");
        modelView.addItem("dogs",new String[]{"Q","W","R"});
        modelView.addItem("alik",new Dog("Alik",20));
        modelView.addItem("length",length);
        return modelView;
    }

    @MappingUrl(url = "dog-dogger")
    public void dogme(String name, Integer age){
        System.out.println("get "+getName());
        System.out.println("get "+getAge());
        System.out.println("param "+name);
        System.out.println("param "+age);
    }

    @MappingUrl(url = "dog-input")
    public ModelView  dog_input(){
        return new ModelView("doginput.jsp");
    }

    @MappingUrl(url = "dog-input2")
    public ModelView  dog_input2(){
        return new ModelView("doginput2.jsp");
    }

    @MappingUrl(url = "dog-add")
    public void dogadd(){
        System.out.println("get "+getName());
        System.out.println("get "+getAge());
        System.out.println("get "+getIs_pro());
    }
}
