package com.example.grocerystoreapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge layout to make content appear behind system UI like status bar
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(R.layout.activity_main); // Set the layout

        // Apply window insets listener to handle padding based on system UI like status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find the "Go to Login" button and set a click listener to navigate to LoginActivity
        Button goToLoginButton = findViewById(R.id.goToLoginButton);
        goToLoginButton.setOnClickListener(v -> {
            // Create an Intent to navigate to LoginActivity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent); // Start the LoginActivity
        });

        // Find the "Register" button and set a click listener to navigate to SignupActivity
        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(v -> {
            // Create an Intent to navigate to SignupActivity
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent); // Start the SignupActivity
        });


    }
}
