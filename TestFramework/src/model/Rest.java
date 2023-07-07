package model;

import annotations.MappingUrl;
import annotations.RestAPI;
import etu1995.framework.ModelView;
import model.entity.Dog;

import java.util.HashMap;

public class Rest {

    public Rest(){

    }

    @MappingUrl(url = "restapi1.do")
    public ModelView Rest1(){
        ModelView modelView = new ModelView();
        modelView.addItem("Balou",new Dog("Balou",5,true));
        modelView.setJson(true);
        return modelView;
    }

    @MappingUrl(url = "restapi2.do")
    @RestAPI
    public String[] Rest2(){
        return new String[]{
                "Balou",
                "Kalou",
                "Jalou"
        };
    }

}
