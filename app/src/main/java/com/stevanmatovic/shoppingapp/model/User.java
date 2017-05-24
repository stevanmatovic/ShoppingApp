package com.stevanmatovic.shoppingapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stevan on 5/23/2017.
 */

public class User extends BaseModel implements Serializable {

    private String username;
    private String password;

    private List<Item> userItems = new ArrayList<>();


    public User() {
    }

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<Item> userItems) {
        this.userItems = userItems;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId().equals(user.getId());

    }

}
