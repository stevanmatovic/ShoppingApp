package com.stevanmatovic.shoppingapp.activity;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.database.Cursor;
import android.widget.EditText;
import android.widget.Toast;

;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.dao.UserDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.User;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;

import static android.Manifest.permission.READ_CONTACTS;
@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity{

    public static final int USER_LOGGED = 14;


    @Bean
    UserDao userDao;

    @ViewById
    EditText username;

    @ViewById
    EditText password;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Click
    void login(){
        userDao.readFromFile();
        HashMap<String,User> users = userDao.getUsers();
        String name = username.getText().toString();
        User user = null;

        if(!users.containsKey(name)){
            Toast.makeText(this,"Username does not exist",Toast.LENGTH_LONG).show();
        }else{
            user = users.get(name);
            if(!user.getPassword().equals(password.getText().toString())){

                Toast.makeText(this,user.getPassword() + " i " + password.getText().toString(),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "User " + user.getUsername() + " is logged", Toast.LENGTH_SHORT).show();
                CurrentUser.setCurrentUser(user);
                setResult(USER_LOGGED);
                finish();
            }
        }

    }


}

