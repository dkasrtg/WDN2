package types;

import annotations.MappingUrl;

public class Cat {
    String name;

    public Cat(String name) {
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
}
