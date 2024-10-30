package com.example.grocerystoreapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivity extends AppCompatActivity {
    private TextView textViewItemName, textViewItemPrice, textViewItemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        textViewItemName = findViewById(R.id.textViewItemName);
        textViewItemPrice = findViewById(R.id.textViewItemPrice);
        textViewItemDescription = findViewById(R.id.textViewItemDescription);

        String itemName = getIntent().getStringExtra("item_name");
        // Fetch item details using itemName (from database or mock data)
        // For simplicity, we'll use hardcoded data for now
        textViewItemName.setText(itemName);
        textViewItemPrice.setText("$1.00"); // Set the price as per your logic
        textViewItemDescription.setText("Description for " + itemName);
    }
}
