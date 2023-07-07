package model;

import annotations.MappingUrl;
import etu1995.framework.ModelView;

public class Index {
    public Index(){

    }
    @MappingUrl(url = "index.do")
    public ModelView Index(){
        ModelView modelView = new ModelView("index.jsp");
        return modelView;
    }
}
