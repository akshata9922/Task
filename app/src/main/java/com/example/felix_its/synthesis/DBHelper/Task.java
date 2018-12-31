package com.example.felix_its.synthesis.DBHelper;

public class Task {
    private int id;
    private String name;
    private String room;
    private String appliance;

    public Task(String name, String room, String appliance, String time) {
        this.time = time;
    }

    private  String time;


    public Task(int id, String name, String room, String appliance) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.appliance = appliance;
    }

    public Task(String name, String room, String appliance) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAppliance() {
        return appliance;
    }

    public void setAppliance(String appliance) {
        this.appliance = appliance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
