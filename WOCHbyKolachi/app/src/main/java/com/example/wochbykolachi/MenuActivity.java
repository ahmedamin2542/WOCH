package com.example.wochbykolachi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements WOCHMenuAdapter.OnItemClickListener {
    public int setPic;
    public int PicGet = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent intent = getIntent();
        int i;
         setPic = intent.getIntExtra("key", 0);
        // Initialize the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.productRecyclerView5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Create a list of WOCHMenuProduct items
        List<WOCHMenuProduct> productList = new ArrayList<>();
        for(i=0; i<10; i++) {
            productList.add(new WOCHMenuProduct(setPic, "Product ", 49.99));
        }
        // Add more products as needed

        // Create and set the adapter
        WOCHMenuAdapter menuAdapter = new WOCHMenuAdapter(productList, this);
        recyclerView.setAdapter(menuAdapter);
    }

    @Override
    public void onItemClick(WOCHMenuProduct product) {
        Intent intent = new Intent(MenuActivity.this, ProductInfo.class);
        PicGet = setPic;
        intent.putExtra("Get", PicGet);
        startActivity(intent);
    }

}
