package types;

import annotations.MappingUrl;

public class Dog {
    String name;

    public Dog(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MappingUrl(url = "insert")
    public void insert(){

    }
    @MappingUrl(url = "delete")
    public void delete(){

    }
}
