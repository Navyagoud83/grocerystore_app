package com.example.grocerystoreapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroceryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GroceryAdapter groceryAdapter;
    private List<GroceryItem> groceryItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        recyclerView = findViewById(R.id.recyclerViewGroceries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize grocery items
        groceryItemList = new ArrayList<>();
        groceryItemList.add(new GroceryItem("Apples", R.drawable.apple)); // Add your drawable resource
        groceryItemList.add(new GroceryItem("Bananas", R.drawable.banana));
        groceryItemList.add(new GroceryItem("Milk", R.drawable.milk));
        groceryItemList.add(new GroceryItem("Bread", R.drawable.bread));
        groceryItemList.add(new GroceryItem("Eggs", R.drawable.egg));

        // Set up adapter
        groceryAdapter = new GroceryAdapter(groceryItemList);
        recyclerView.setAdapter(groceryAdapter);
    }
}
