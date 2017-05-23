package com.stevanmatovic.shoppingapp.dao;

import android.content.Context;

import com.stevanmatovic.shoppingapp.activity.MainActivity;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stevan on 5/23/2017.
 */

@EBean(scope = EBean.Scope.Singleton)
public class ItemDao {

    @RootContext
    Context context;

    private String file = "items";
    private List<Item> items = new ArrayList<>();


    @AfterInject
    void init(){
        readFromFile();
    }

    public void write(Item item){
        items.add(item);
        updateFile();


    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        updateFile();
    }

    public void readFromFile(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(file);
            ois = new ObjectInputStream(fis);
            items.clear();
            items = ((List<Item>)ois.readObject());
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateFile(){
        try {

            FileOutputStream fos = context.openFileOutput(file, context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
