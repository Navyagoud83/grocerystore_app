package com.example.grocerystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize the buttons
        Button buttonProfile = findViewById(R.id.button1);
        Button buttonCart = findViewById(R.id.button2);
        Button buttonGrocery = findViewById(R.id.button3);
        Button buttonPayment = findViewById(R.id.button4);
        Button buttonPickup = findViewById(R.id.button5);

        // Set click listener for My Profile button
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ProfileActivity
                Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for My Cart button
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CartActivity
                Intent intent = new Intent(DashboardActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Grocery button
        buttonGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to GroceryActivity
                Intent intent = new Intent(DashboardActivity.this, GroceryActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Payment Option button
        buttonPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to PaymentActivity
                Intent intent = new Intent(DashboardActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for Pickup Location button
        buttonPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to PickupLocationActivity
                Intent intent = new Intent(DashboardActivity.this, PickupLocationActivity.class);
                startActivity(intent);
            }
        });
    }
}
