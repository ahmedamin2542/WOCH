package com.example.wochbykolachi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class ProductInfoAdapter extends BaseAdapter {
    private Context context;
    private List<ProductDisplay> productList;

    public ProductInfoAdapter(Context context, List<ProductDisplay> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_info, parent, false);
        }

        // Get the current product
        ProductDisplay product = productList.get(position);

        // Set the product name
        TextView nameTextView = convertView.findViewById(R.id.textName);
        nameTextView.setText(product.getName());

        // Set the product price
        TextView priceTextView = convertView.findViewById(R.id.textPrice);
        priceTextView.setText(product.getPrice());

        // Set the product rating
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);
        ratingBar.setRating(product.getRating());

        // Set the review person
        TextView reviewPersonTextView = convertView.findViewById(R.id.textReviewPerson);
        reviewPersonTextView.setText(product.getReviewPerson());

        // Set the reviews
        TextView reviewsTextView = convertView.findViewById(R.id.textReviews);
        reviewsTextView.setText(product.getReviews());

        // Set the description
        TextView descriptionTextView = convertView.findViewById(R.id.textDescription);
        descriptionTextView.setText(product.getDescription());

        return convertView;
    }
}
