package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.dao.UserDao;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @Bean
    UserDao userDao;



}
