package com.example.lab_15_last_lat;

import java.util.Date;

public class Product {
    private String name;
    private String description;

    private Date time;
    private int id;


    public Product(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.time = new Date();
    }
    public String getTime() {
        time = new Date();
        return time.toString();

    }

    public void setTime(Date time) {
        this.time = time;
    }
    public Product() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
