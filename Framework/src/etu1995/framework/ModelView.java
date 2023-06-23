package etu1995.framework;

import java.util.HashMap;

public class ModelView {
    String view;
    HashMap<String, Object> data;
    HashMap<String, Object> session;
    boolean json;

    public ModelView(String view) {
        setView(view);
        setData(new HashMap<>());
        setSession(new HashMap<>());
        setJson(false);
    }

    public void setJson(boolean json) {
        this.json = json;
    }

    public boolean getJson() {
        return json;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void addItem(String key, Object value){
        getData().put(key,value);
    }

    public void setSession(HashMap<String, Object> session) {
        this.session = session;
    }

    public HashMap<String, Object> getSession() {
        return session;
    }

    public void addSession(String key, Object value){
        getSession().put(key,value);
    }
}
