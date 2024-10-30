package com.example.grocerystoreapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PickupLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup_location);

        ListView listViewPickupLocations = findViewById(R.id.listViewPickupLocations);

        // Sample pickup locations
        String[] pickupLocations = {
                "Metro",
                "Walmart",
                "NoFrills",
                "Freshco"
        };

        // Create an ArrayAdapter to display the pickup locations in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pickupLocations);
        listViewPickupLocations.setAdapter(adapter);

        // Set an item click listener to handle selection
        listViewPickupLocations.setOnItemClickListener((parent, view, position, id) -> {
            String selectedLocation = pickupLocations[position];
            Toast.makeText(PickupLocationActivity.this, "Selected: " + selectedLocation, Toast.LENGTH_SHORT).show();
            // Here you can implement additional logic, like storing the selected location or navigating to another screen.
        });
    }
}
