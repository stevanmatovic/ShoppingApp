package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.adapter.ItemAdapter;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ListView listView;

    @Bean
    ItemDao itemDao;

    @Bean
    ItemAdapter itemAdapter;

    @AfterViews
    void init(){

        listView.setAdapter(itemAdapter);
    }

    @Click
    void fab(){
        itemDao.write(new Item("Telefon", "LG K10", new Date(),"200eur", null));
        Toast.makeText(MainActivity.this, itemDao.getItems().toString(), Toast.LENGTH_LONG).show();
    }

}
