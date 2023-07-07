package model;

import annotations.MappingUrl;
import annotations.Session;
import etu1995.framework.ModelView;
import model.entity.Dog;

import java.util.HashMap;
import java.util.Vector;

public class CRUD {

    HashMap<String,Object> sessions;


    public CRUD(){

    }

    public void setSessions(HashMap<String, Object> sessions) {
        this.sessions = sessions;
    }

    public HashMap<String, Object> getSessions() {
        return sessions;
    }


    @MappingUrl(url = "crud.do")
    @Session
    public ModelView Read(){
        ModelView modelView = new ModelView("crud.jsp");
        if (!getSessions().containsKey("list")){
            Vector<Dog> dogs = new Vector<>();
            modelView.addSession("list",dogs);
            modelView.addItem("list",new Vector<Dog>());
        }
        else {
            modelView.addItem("list",(Vector<Dog>) getSessions().get("list"));
        }
        return modelView;
    }

    @MappingUrl(url = "crud_create.do")
    @Session
    public ModelView Create(String name,Integer age){
        ModelView modelView = new ModelView("redirect.jsp");
        Vector<Dog> dogs = (Vector<Dog>) getSessions().get("list");
        Dog dog = new Dog(name,age);
        dogs.add(dog);
        modelView.addSession("list",dogs);
        modelView.addItem("link","/TestFramework/crud.do");
        return modelView;
    }

    @MappingUrl(url = "crud_update.do")
    @Session
    public ModelView Update(Integer index){
        ModelView modelView = new ModelView("crudupdate.jsp");
        Vector<Dog> dogs = (Vector<Dog>) getSessions().get("list");
        modelView.addItem("index",index);
        modelView.addItem("dog",dogs.get(index));
        return modelView;
    }

    @MappingUrl(url = "crud_valid_update.do")
    @Session
    public ModelView validUpdate(Integer index,String name,Integer age){
        ModelView modelView = new ModelView("redirect.jsp");
        Vector<Dog> dogs = (Vector<Dog>) getSessions().get("list");
        dogs.get(index).setName(name);
        dogs.get(index).setAge(age);
        modelView.addSession("list",dogs);
        modelView.addItem("link","/TestFramework/crud.do");
        return modelView;
    }

    @MappingUrl(url = "crud_delete.do")
    @Session
    public ModelView Delete(Integer index){
        ModelView modelView = new ModelView("redirect.jsp");
        Vector<Dog> dogs = (Vector<Dog>) getSessions().get("list");
        dogs.removeElementAt(index);
        modelView.addSession("list",dogs);
        modelView.addItem("link","/TestFramework/crud.do");
        return modelView;
    }
}
