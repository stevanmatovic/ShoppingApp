package com.stevanmatovic.shoppingapp.dao;

import android.content.Context;

import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;
import com.stevanmatovic.shoppingapp.model.User;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Stevan on 5/24/2017.
 */
@EBean(scope = EBean.Scope.Singleton)
public class UserDao {

    @RootContext
    Context context;

    private String file = "users";
    private HashMap<String,User> users = new HashMap<>();

    @AfterInject
    void init(){
        readFromFile();
    }



    public void write(User user){
        readFromFile();
        users.put(user.getUsername(),user);
        updateFile();
    }

    public void write(Item i) {
        User cur = users.get(CurrentUser.getCurrentUser().getUsername());
        cur.getUserItems().add(i);
        updateFile();
    }

    public void readFromFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(file);
            ois = new ObjectInputStream(fis);
            users.clear();
            users = (HashMap<String, User>) ois.readObject();
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
            oos.writeObject(users);
            oos.close();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }


}
