package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.dao.UserDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_edit_item)
public class EditItemActivity extends AppCompatActivity {

    @Extra
    int position;


    @ViewById
    EditText name;

    @Bean
    ItemDao itemDao;

    @Bean
    UserDao userDao;

    @ViewById
    EditText price;

    @ViewById
    EditText description;

    Item i = null;

    @AfterViews
    void init(){
        i = CurrentUser.getCurrentUser().getUserItems().get(position);
        name.setText(i.getName());
        price.setText(i.getPrice());
        description.setText(i.getDescription());
    }

    @Click
    void update(){
        if(i!=null){
            itemDao.changeItem(i,name.getText().toString(),price.getText().toString(),description.getText().toString());
            i.setName(name.getText().toString());
            i.setPrice(price.getText().toString());
            i.setDescription(description.getText().toString());
            userDao.updateItem(i,position);
            finish();
        }
    }

}
