package com.stevanmatovic.shoppingapp.model;

import java.io.Serializable;

/**
 * Created by Stevan on 5/23/2017.
 */

public abstract class BaseModel implements Serializable {

    private String id;

    public BaseModel(String id) {
        this.id = id;
    }

    public BaseModel(){

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
