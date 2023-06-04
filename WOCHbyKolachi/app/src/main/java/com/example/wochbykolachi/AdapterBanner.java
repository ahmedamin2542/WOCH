package com.example.wochbykolachi;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class AdapterBanner extends PagerAdapter {
    private Context context;
    private List<Integer> images;

    public AdapterBanner(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        // Action for the first image
                        openActivity1();
                        break;
                    case 1:
                        // Action for the second image
                        openActivity2();
                        break;
                    case 2:
                        // Action for the third image
                        openActivity3();
                        break;
                    default:
                        break;
                }
            }

            private void openActivity1() {
                Intent intent = new Intent(context, MenuActivity.class);
                context.startActivity(intent);
            }

            private void openActivity2() {
                Intent intent = new Intent(context, MenuActivity.class);
                context.startActivity(intent);
            }

            private void openActivity3() {
                Intent intent = new Intent(context, MenuActivity.class);
                context.startActivity(intent);
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
