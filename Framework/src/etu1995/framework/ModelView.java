package etu1995.framework;

import java.util.HashMap;
import java.util.Vector;

public class ModelView {
    String view;
    HashMap<String, Object> data;
    HashMap<String, Object> session;
    boolean json;
    boolean invalidateSession;
    Vector<String> removeSessions;

    public ModelView(String view) {
        setView(view);
        setData(new HashMap<>());
        setSession(new HashMap<>());
        setJson(false);
        setInvalidateSession(false);
        setRemoveSessions(new Vector<>());
    }

    public ModelView() {
        setData(new HashMap<>());
        setSession(new HashMap<>());
        setJson(false);
        setInvalidateSession(false);
        setRemoveSessions(new Vector<>());
    }

    public boolean getInvalidateSession() {
        return invalidateSession;
    }

    public void setInvalidateSession(boolean invalidateSession) {
        this.invalidateSession = invalidateSession;
    }

    public Vector<String> getRemoveSessions() {
        return removeSessions;
    }

    public void setRemoveSessions(Vector<String> removeSessions) {
        this.removeSessions = removeSessions;
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

    public void addRemoveSession(String session){
        getRemoveSessions().add(session);
    }
}
