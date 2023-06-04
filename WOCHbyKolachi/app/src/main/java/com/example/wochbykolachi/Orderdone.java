package com.example.wochbykolachi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Orderdone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdone);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(Orderdone.this, Home.class);
        startActivity(intent);
    }
}