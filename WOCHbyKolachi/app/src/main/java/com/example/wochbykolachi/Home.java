package com.example.wochbykolachi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private ViewPager viewPager;
    private ImagePagerAdapter adapter;
    private List<Integer> images;
    private static final int AUTO_SCROLL_DELAY = 3000; // Delay in milliseconds
    private Handler autoScrollHandler;
    private Runnable autoScrollRunnable;
    public int i;
    public int pic,WatchPic,PicGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize ViewPager
        viewPager = findViewById(R.id.viewPager);

        // Prepare the list of images (replace with your own images)
        images = new ArrayList<>();
        images.add(R.drawable.casualwatches);
        images.add(R.drawable.sportwatches);
        images.add(R.drawable.luxurywatches);

        // Create and set the adapter
        adapter = new ImagePagerAdapter(this, images);
        viewPager.setAdapter(adapter);

        // Auto-scrolling
        autoScrollHandler = new Handler();
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                int totalCount = adapter.getCount();
                int nextItem = (currentItem + 1) % totalCount;
                viewPager.setCurrentItem(nextItem);
                autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY);
            }
        };

        // Start auto-scrolling when the activity is resumed
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);

        // Set onPageChangeListener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
// Initialize the second RecyclerView
        RecyclerView recyclerView2 = findViewById(R.id.productRecyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        pic = R.drawable.pic0;
// Create a list of products for the second RecyclerView
        List<Product> productList2 = new ArrayList<>();
        for(i=0; i<10; i++) {
            productList2.add(new Product("Product ", pic, 49.99));
        }
// Add more products as needed

// Create the adapter for the second RecyclerView and set it
        ProductAdapter productAdapter2 = new ProductAdapter(productList2);
        recyclerView2.setAdapter(productAdapter2);

        // Initialize the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.productRecyclerView5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create a list of products
        List<Product> productList = new ArrayList<>();
        Bundle transfer = new Bundle();
        for(i=0; i<10; i++) {
            productList.add(new Product("Product ", pic, 49.99));
        }

        // Add more products as needed

        // Create the adapter and set it to the RecyclerView
        ProductAdapter productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop auto-scrolling when the activity is paused
        autoScrollHandler.removeCallbacks(autoScrollRunnable);
    }

    public void onClickProduct(View view) {
        Intent intent = new Intent(Home.this, ProductInfo.class);
        PicGet = R.drawable.pic0;
        intent.putExtra("Get", PicGet);
        startActivity(intent);
    }

    // ImagePagerAdapter class
    private class ImagePagerAdapter extends PagerAdapter {
        private final Context context;
        private final List<Integer> images;

        public ImagePagerAdapter(Context context, List<Integer> images) {
            this.context = context;
            this.images = images;
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(images.get(position));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (position) {
                        case 0:
                            // Action for the first image
                            WatchPic = R.drawable.pic1;
                            nextActivity();
                            break;
                        case 1:
                            // Action for the second image
                            WatchPic = R.drawable.pic2;
                            nextActivity();
                            break;
                        case 2:
                            // Action for the third image
                            WatchPic = R.drawable.pic3;
                            nextActivity();
                            break;
                        default:
                            break;
                    }
                }

                public void nextActivity(){
                    Intent intent = new Intent(context, MenuActivity.class);
                    intent.putExtra("key", WatchPic);
                    context.startActivity(intent);
                }

            });
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
