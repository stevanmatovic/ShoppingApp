package com.stevanmatovic.shoppingapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.adapter.ItemAdapter;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.dao.UserDao;
import com.stevanmatovic.shoppingapp.model.CurrentUser;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity(R.layout.activity_user_items)
public class UserItems extends AppCompatActivity {

    @ViewById
    ListView listView;

    @Bean
    ItemDao itemDao;

    @Bean
    UserDao userDao;

    @Bean
    ItemAdapter itemAdapter;

    @AfterViews
    void init(){
        List<Item> currentUserItems = CurrentUser.getCurrentUser().getUserItems();
        itemAdapter.setItems(currentUserItems);
        listView.setAdapter(itemAdapter);

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @ItemClick(R.id.listView)
    void itemClick(int position){
        Item i = itemAdapter.getItem(position);
        EditItemActivity_.intent(this).position(position).start();
        itemAdapter.notifyDataSetChanged();
    }

}
