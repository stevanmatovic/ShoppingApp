package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.adapter.ItemAdapter;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
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

        if(CurrentUser.getCurrentUser() == null)
            Toast.makeText(MainActivity.this, "You must be logged in to post items", Toast.LENGTH_LONG).show();
        else{

        }
    }


}
