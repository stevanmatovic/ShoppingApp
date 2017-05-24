package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.adapter.ItemAdapter;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main_menu)
public class MainActivity extends AppCompatActivity {

    @ViewById
    GridView listView;

    @Bean
    ItemDao itemDao;

    @Bean
    ItemAdapter itemAdapter;

    @AfterViews
    void init(){
        listView.setAdapter(itemAdapter);


    }

    @OptionsItem
    void gridSelected(){
        if(listView.getNumColumns() == 1)
            listView.setNumColumns(2);
        else
            listView.setNumColumns(1);
    }

    @OptionsItem
    void registerSelected(){
        RegisterActivity_.intent(this).startForResult(1);

    }

    @OptionsItem
    void myItemsSelected(){
        if(CurrentUser.getCurrentUser() == null){
            Toast.makeText(this,"You must be logged in",Toast.LENGTH_SHORT);
            return;
        }
        UserItems_.intent(this).startForResult(1);
        itemAdapter.notifyDataSetChanged();
    }

    @OnActivityResult(1)
    void update(){
        itemAdapter.notifyDataSetChanged();
    }

    @OptionsItem
    void loginSelected(){
        LoginActivity_.intent(this).start();

    }

    @Click
    void fab(){
        itemDao.updateFile();

        if(CurrentUser.getCurrentUser() == null)
            Toast.makeText(MainActivity.this, "You must be logged in to post items", Toast.LENGTH_LONG).show();
        else{
            NewItemActivity_.intent(this).start();
            itemAdapter.notifyDataSetChanged();
        }
    }


}
