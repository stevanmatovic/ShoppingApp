package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.dao.UserDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_new_item)
public class NewItemActivity extends AppCompatActivity {

    @Bean
    ItemDao itemDao;

    @Bean
    UserDao userDao;

    @ViewById
    EditText name;

    @ViewById
    EditText description;

    @ViewById
    EditText price;

    @Click
    public void add(){
        if(name.getText().toString() == null || name.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Name must be filled in",Toast.LENGTH_SHORT);
        }else if(price.getText().toString() == null || price.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"Price must be filled in",Toast.LENGTH_SHORT);
        }else{
            Item i = new Item(name.getText().toString(),description.getText().toString(),price.getText().toString(), CurrentUser.getCurrentUser());
            itemDao.write(i);
            userDao.write(i);
            finish();
        }
    }

}
