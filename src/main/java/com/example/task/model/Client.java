package com.example.task.model;

public class Client {

    private String id;
    private String name;

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
/** Создаём Id и имя пользователя, конструктор, гетеры, сетеры, вот это всё **/