package com.stevanmatovic.shoppingapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.stevanmatovic.shoppingapp.View.ShoppingItemView;
import com.stevanmatovic.shoppingapp.View.ShoppingItemView_;
import com.stevanmatovic.shoppingapp.dao.ItemDao;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stevan on 5/23/2017.
 */
@EBean
public class ItemAdapter extends BaseAdapter {

    private List<Item> items = new ArrayList<>();

    @RootContext
    Context context;

    @Bean
    ItemDao itemDao;


    @AfterInject
    void init(){
        setItems(itemDao.getItems());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShoppingItemView shoppingItemView;
        if(convertView == null){
            shoppingItemView = ShoppingItemView_.build(context);
        }else{
            shoppingItemView = (ShoppingItemView) convertView;
        }
        shoppingItemView.bind(items.get(position));

        return shoppingItemView;
    }


    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public List<Item> getItems() {
        return items;
    }
}
