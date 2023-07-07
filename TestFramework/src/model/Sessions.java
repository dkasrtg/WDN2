package model;

import annotations.MappingUrl;
import annotations.Session;
import etu1995.framework.ModelView;

import java.util.HashMap;
import java.util.Vector;

public class Sessions {

    HashMap<String,Object> sessions;

    public Sessions(){

    }

    public void setSessions(HashMap<String, Object> sessions) {
        this.sessions = sessions;
    }

    public HashMap<String, Object> getSessions() {
        return sessions;
    }

    @MappingUrl(url = "session.do")
    @Session
    public ModelView Index(){
        ModelView modelView = new ModelView("session.jsp");
        Vector<String[]> sessions = new Vector<>();
        getSessions().forEach(
                (key,value)
                        -> sessions.add(new String[]{key,value.toString()})
        );
        modelView.addItem("sessions",sessions);
        return modelView;
    }

    @MappingUrl(url = "session_creation.do")
    @Session
    public ModelView New(String name,String value){
        ModelView modelView = new ModelView("redirect.jsp");
        modelView.addItem("link","/TestFramework/session.do");
        modelView.addSession(name,value);
        return modelView;
    }

    @MappingUrl(url = "session_delete.do")
    @Session
    public ModelView Delete(String name){
        ModelView modelView = new ModelView("redirect.jsp");
        modelView.addItem("link","/TestFramework/session.do");
        modelView.getRemoveSessions().add(name);
        return modelView;
    }

    @MappingUrl(url = "session_delete_all.do")
    @Session
    public ModelView DeleteAll(){
        ModelView modelView = new ModelView("redirect.jsp");
        modelView.addItem("link","/TestFramework/session.do");
        modelView.setInvalidateSession(true);
        return modelView;
    }

}
