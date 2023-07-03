package model;

import annotations.MappingUrl;
import annotations.RestAPI;
import annotations.Scope;
import annotations.Session;
import etu1995.framework.ModelView;

import java.util.HashMap;

@Scope(type = "singleton")
public class Dog {
    String name;

    int age;

    boolean is_pro;

    HashMap<String,Object> sessions;

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

    public void setSessions(HashMap<String, Object> sessions) {
        this.sessions = sessions;
    }

    public HashMap<String, Object> getSessions() {
        return sessions;
    }

    @MappingUrl(url = "dog-all.do")
    public ModelView findAll(Integer length){
        ModelView modelView = new ModelView("dog.jsp");
        modelView.addItem("dogs",new String[]{"Q","W","R"});
        modelView.addItem("alik",new Dog("Alik",20));
        modelView.addItem("length",length);
        modelView.setJson(true);
        return modelView;
    }

    @MappingUrl(url = "dog-all2.do")
    @RestAPI
    public String[] findAll2(Integer length){
        return new String[]{
                "a","f","f"
        };
    }

    @MappingUrl(url = "dog-dogger.do")
    public void dogme(String name, Integer age){
        System.out.println("get "+getName());
        System.out.println("get "+getAge());
        System.out.println("param "+name);
        System.out.println("param "+age);
    }

    @MappingUrl(url = "dog-input.do")
    public ModelView  dog_input(){
//        String po  = "sdvdsv";
//        double coco = Double.parseDouble(po);
        ModelView modelView = new ModelView("doginput.jsp");
        modelView.addSession("po","po");
        modelView.addSession("co",120);
        return modelView;
    }

    @MappingUrl(url = "dog-input2.do")
    public ModelView  dog_input2() throws Exception {
        return new ModelView("dogut2.jsp");
    }

    @MappingUrl(url = "dog-add.do")
    public void dogadd(){
        System.out.println("get "+getName());
        System.out.println("get "+getAge());
        System.out.println("get "+getIs_pro());
    }

    @MappingUrl(url = "dog-session.do")
    @Session
    public void dogsession(){
        getSessions().forEach(
                (key,value)
                    -> System.out.println(key+" : "+value)
        );
    }
}
