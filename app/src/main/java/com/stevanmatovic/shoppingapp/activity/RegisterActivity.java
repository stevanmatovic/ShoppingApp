package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.dao.UserDao;
import com.stevanmatovic.shoppingapp.model.User;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    public static final int USER_ADDED = 12;

    @Bean
    UserDao userDao;

    @ViewById
    EditText username;//kaa ka

    @ViewById
    EditText password;

    @ViewById
    EditText passwordRepeat;

    @Click
    void register(){
        if(username.getText().toString() == null || username.getText().toString().isEmpty()){
            Toast.makeText(this, "Username not filled!", Toast.LENGTH_LONG).show();
        }else if(password.getText().toString() == null || password.getText().toString().isEmpty()){
            Toast.makeText(this, "Password not filled!", Toast.LENGTH_LONG).show();
        }else if(!password.getText().toString().equals(passwordRepeat.getText().toString())){
            Toast.makeText(this, "Password retype incorrect!", Toast.LENGTH_LONG).show();
        }else{
            HashMap<String,User> users= userDao.getUsers();
            if(users.containsKey(username.getText().toString())){
                Toast.makeText(this, "Username already exists", Toast.LENGTH_LONG).show();
            }else{
                String pass = password.getText().toString();
                String us = username.getText().toString();
                User user = new User(us,pass);
                userDao.write(user);
                finish();
            }
        }
    }

}
