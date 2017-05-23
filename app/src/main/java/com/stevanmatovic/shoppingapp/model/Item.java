package com.stevanmatovic.shoppingapp.model;

import java.util.Date;

/**
 * Created by Stevan on 5/23/2017.
 */

public class Item extends BaseModel{

    private String name;
    private String description;
    private Date date;
    private String price;

    private User user;

    public Item() {
    }

    public Item(String name, String description, Date date, String price, User user) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.price = price;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
