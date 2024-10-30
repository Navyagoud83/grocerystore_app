package com.example.grocerystoreapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private RadioGroup radioGroupPaymentOptions;
    private Button buttonProceedPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        radioGroupPaymentOptions = findViewById(R.id.radioGroupPaymentOptions);
        buttonProceedPayment = findViewById(R.id.buttonProceedPayment);

        buttonProceedPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupPaymentOptions.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedOption = selectedRadioButton.getText().toString();
                Toast.makeText(PaymentActivity.this, "Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
                // Proceed with the payment processing
            }
        });
    }
}
