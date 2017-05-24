package com.stevanmatovic.shoppingapp.View;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stevanmatovic.shoppingapp.R;
import com.stevanmatovic.shoppingapp.model.Item;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;


/**
 * Created by Stevan on 5/23/2017.
 */
@EViewGroup(R.layout.item_view_shopping_item)
public class ShoppingItemView extends LinearLayout {



    @ViewById
    TextView name;

    @ViewById
    TextView description;

    @ViewById
    TextView price;


    public ShoppingItemView(Context context) {
        super(context);
    }

    public void bind(Item item)
    {
        name.setText(item.getName());
        description.setText(item.getDescription());
        price.setText("Cena: " + item.getPrice());
    }
}
