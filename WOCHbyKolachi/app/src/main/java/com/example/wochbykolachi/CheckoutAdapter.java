package com.example.wochbykolachi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {

    private Context context;
    private List<CheckoutItem> checkoutItemList;

    public CheckoutAdapter(Context context, List<CheckoutItem> checkoutItemList) {
        this.context = context;
        this.checkoutItemList = checkoutItemList;
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.checkout_item, parent, false);
        return new CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        CheckoutItem checkoutItem = checkoutItemList.get(position);

        holder.productImage.setImageResource(checkoutItem.getImageResource());
        holder.productTitle.setText(checkoutItem.getTitle());
        holder.price.setText(checkoutItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return checkoutItemList.size();
    }

    public class CheckoutViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productTitle;
        TextView price;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            price = itemView.findViewById(R.id.price);
        }
    }
}
