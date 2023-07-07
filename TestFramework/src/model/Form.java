package model;

import annotations.MappingUrl;
import etu1995.framework.FileUpload;
import etu1995.framework.ModelView;

import java.sql.Date;

public class Form {

    public Form(){

    }

    @MappingUrl(url = "form.do")
    public ModelView Index(){
        ModelView modelView = new ModelView("form.jsp");
        return modelView;
    }

    @MappingUrl(url = "formdata.do")
    public ModelView FormData(String text,
                              String mail,
                              String password,
                              String textarea,
                              String[] checkbox,
                              String radio,
                              String select,
                              FileUpload file,
                              FileUpload[] files,
                              Date date,
                              Integer number,
                              String color){
        ModelView modelView = new ModelView("formdata.jsp");
        modelView.addItem("text",text);
        modelView.addItem("mail",mail);
        modelView.addItem("password",password);
        modelView.addItem("textarea",textarea);
        modelView.addItem("checkbox",checkbox);
        modelView.addItem("radio",radio);
        modelView.addItem("select",select);
        modelView.addItem("file",file);
        modelView.addItem("files",files);
        modelView.addItem("date",date);
        modelView.addItem("number",number);
        modelView.addItem("color",color);
        return modelView;
    }
}
