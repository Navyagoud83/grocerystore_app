package com.example.grocerystoreapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<CartActivity.GroceryItem> {

    private final ArrayList<CartActivity.GroceryItem> groceryItems;

    public CartAdapter(Context context, ArrayList<CartActivity.GroceryItem> groceryItems) {
        super(context, R.layout.cart_item, groceryItems);
        this.groceryItems = groceryItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartActivity.GroceryItem item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cart_item, parent, false);
        }

        // Get the views
        TextView textViewItemName = convertView.findViewById(R.id.textViewItemName);
        TextView textViewItemPrice = convertView.findViewById(R.id.textViewItemPrice);
        ImageView imageViewItem = convertView.findViewById(R.id.imageViewItem);
        Button buttonDecrease = convertView.findViewById(R.id.buttonDecrease);
        TextView textViewQuantity = convertView.findViewById(R.id.textViewQuantity);
        Button buttonIncrease = convertView.findViewById(R.id.buttonIncrease);

        // Set the data for each grocery item
        textViewItemName.setText(item.name);
        textViewItemPrice.setText("Price: $" + String.format("%.2f", item.price));
        textViewQuantity.setText(String.valueOf(item.quantity));
        imageViewItem.setImageResource(item.imageResId);

        // Handle quantity increase
        buttonIncrease.setOnClickListener(v -> {
            item.quantity++;
            textViewQuantity.setText(String.valueOf(item.quantity));
        });

        // Handle quantity decrease
        buttonDecrease.setOnClickListener(v -> {
            if (item.quantity > 0) {
                item.quantity--;
                textViewQuantity.setText(String.valueOf(item.quantity));
            }
        });

        return convertView;
    }
}
