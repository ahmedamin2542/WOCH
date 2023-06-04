package com.example.wochbykolachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class checkout extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editContactNo;
    private EditText editTextAddress;
    private TextView invalidTextView; // Renamed variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        RecyclerView productRecyclerView = findViewById(R.id.productRecyclerView);
        List<CheckoutItem> checkoutItemList = new ArrayList<>();

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editContactNo = findViewById(R.id.editContactNo);
        editTextAddress = findViewById(R.id.editTextAddress);
        invalidTextView = findViewById(R.id.invalidTextView); // Updated variable initialization

        Intent intent = getIntent();
        int checkoutPic = intent.getIntExtra("Checkout", 0);

        // Add items dynamically to the list
        checkoutItemList.add(new CheckoutItem(checkoutPic, "Product 1", "$49.99"));
        // Add more items as needed

        CheckoutAdapter checkoutAdapter = new CheckoutAdapter(this, checkoutItemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productRecyclerView.setLayoutManager(layoutManager);
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.setAdapter(checkoutAdapter);
    }

    public void Confirm(View view) {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String contact = editContactNo.getText().toString();
        String address = editTextAddress.getText().toString();
        String invalid = invalidTextView.getText().toString(); // Updated variable name

        if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || address.isEmpty()) {
            invalidTextView.setText("Please input all fields");
        } else {
            Intent intent = new Intent(checkout.this, Orderdone.class);
            startActivity(intent);
        }
    }
}
