package model;

import annotations.MappingUrl;
import etu1995.framework.FileUpload;
import etu1995.framework.ModelView;

import java.util.Arrays;
import java.util.HashMap;

public class Cat {
    String name;
    FileUpload kely;
    FileUpload[] be;

    String[] cara;

    int raw;

    public Cat() {
    }

    public Cat(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FileUpload getKely() {
        return kely;
    }

    public void setKely(FileUpload kely) {
        this.kely = kely;
    }

    public FileUpload[] getBe() {
        return be;
    }

    public void setBe(FileUpload[] be) {
        this.be = be;
    }

    public String[] getCara() {
        return cara;
    }

    public void setCara(String[] cara) {
        this.cara = cara;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    public int getRaw() {
        return raw;
    }

    @MappingUrl(url = "cat-all")
    public ModelView findAll(){
        return new ModelView("cat.jsp");
    }

    @MappingUrl(url = "cat-insert")
    public ModelView insert(){
        return new ModelView("test.jsp");
    }

    @MappingUrl(url = "cat-get")
    public void get(FileUpload kely,FileUpload[] be,String[] cara,int raw){
        System.out.println(kely.getName());
        System.out.println(be.length);
        System.out.println(Arrays.toString(cara));
        System.out.println(raw);
        System.out.println("=====");
        System.out.println(getKely().getName());
        System.out.println(getBe().length);
        System.out.println(Arrays.toString(getCara()));
        System.out.println(getRaw());
    }
}
