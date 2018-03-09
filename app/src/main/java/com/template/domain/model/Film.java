package com.template.domain.model;

public class Film extends BaseModel {
    private String id;
    private String name;
    private String director;

    public Film() {
    }

    public Film(String id, String name, String director) {
        this.name = name;
        this.id = id;
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
