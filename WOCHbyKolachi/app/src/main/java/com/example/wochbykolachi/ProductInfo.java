package com.example.wochbykolachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo extends AppCompatActivity {

    private List<ProductDisplay> productList;
    private ProductInfoAdapter adapter;
    private ViewPager viewPager;
    private List<Integer> images;
    public int GetPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        Intent intent = getIntent();
       GetPic = intent.getIntExtra("Get", 0);
        // Initialize ViewPager
        viewPager = findViewById(R.id.viewPager);

        // Prepare the list of images (replace with your own images)
        images = new ArrayList<>();
        images.add(GetPic);
        images.add(GetPic);
        images.add(GetPic);

        // Create a list of products
        productList = new ArrayList<>();
        productList.add(new ProductDisplay("Product", 49.99, 4.5f, "John Doe", "Great product!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam fringilla leo, id condimentum sapien. Sed rhoncus consequat metus nec rutrum Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec aliquam fringilla leo, id condimentum sapien. Sed rhoncus consequat metus nec rutrum."));

        // Create the adapter
        adapter = new ProductInfoAdapter(this, productList);

        // Set the adapter to the ListView
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // Set the adapter to the ViewPager
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return images.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(ProductInfo.this);
                imageView.setImageResource(images.get(position));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ImageView) object);
            }
        });

        // Color Selection Card
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    // Handle color selection here
                    RadioButton radioButton = findViewById(checkedId);
                    String selectedColor = radioButton.getText().toString();
                    // Perform actions based on selectedColor
                }
            });
        }
    }

    public void onOrderNowClicked(View view) {
        Intent intent = new Intent(ProductInfo.this, checkout.class);
        intent.putExtra("Checkout", GetPic);
        startActivity(intent);
    }
}
