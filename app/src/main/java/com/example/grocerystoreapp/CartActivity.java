package com.example.grocerystoreapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ListView listViewCartItems;
    private TextView textViewTotal;
    private Button buttonCalculateTotal;

    // Grocery item model class
    static class GroceryItem {
        String name;
        double price;
        int quantity;
        int imageResId; // Image resource ID

        GroceryItem(String name, double price, int imageResId) {
            this.name = name;
            this.price = price;
            this.quantity = 0; // Default quantity is 0
            this.imageResId = imageResId;
        }
    }

    private ArrayList<GroceryItem> groceryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listViewCartItems = findViewById(R.id.listViewCartItems);
        textViewTotal = findViewById(R.id.textViewTotal);
        buttonCalculateTotal = findViewById(R.id.buttonCalculateQuantity);

        // Sample grocery items with images
        groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItem("Apples", 1.00, R.drawable.apple));
        groceryItems.add(new GroceryItem("Bananas", 0.50, R.drawable.banana));
        groceryItems.add(new GroceryItem("Milk", 1.50, R.drawable.milk));
        groceryItems.add(new GroceryItem("Bread", 2.00, R.drawable.bread));
        groceryItems.add(new GroceryItem("Eggs", 0.20, R.drawable.egg));

        // Set the custom adapter for the ListView
        CartAdapter adapter = new CartAdapter();
        listViewCartItems.setAdapter(adapter);

        // Set up the calculate total button
        buttonCalculateTotal.setOnClickListener(v -> {
            double total = 0.0;
            for (GroceryItem item : groceryItems) {
                total += item.price * item.quantity;
            }
            textViewTotal.setText("Total: $" + String.format("%.2f", total));
        });
    }

    // Custom adapter for displaying grocery items
    private class CartAdapter extends ArrayAdapter<GroceryItem> {
        CartAdapter() {
            super(CartActivity.this, R.layout.cart_item, groceryItems);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            GroceryItem item = getItem(position);

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
}
