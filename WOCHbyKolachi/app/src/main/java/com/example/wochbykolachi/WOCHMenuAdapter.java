package com.example.wochbykolachi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WOCHMenuAdapter extends RecyclerView.Adapter<WOCHMenuAdapter.WOCHMenuViewHolder> {
    private List<WOCHMenuProduct> productList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(WOCHMenuProduct product);
    }

    public WOCHMenuAdapter(List<WOCHMenuProduct> productList, OnItemClickListener listener) {
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WOCHMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.woch_menu_product_card, parent, false);
        return new WOCHMenuViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WOCHMenuViewHolder holder, int position) {
        WOCHMenuProduct product = productList.get(position);
        holder.bind(product, listener);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class WOCHMenuViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImageView;
        private TextView productNameTextView;
        private TextView price;

        public WOCHMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImage);
            productNameTextView = itemView.findViewById(R.id.productTitle);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final WOCHMenuProduct product, final OnItemClickListener listener) {
            productImageView.setImageResource(product.getImage());
            productNameTextView.setText(product.getTitle());
            price.setText(String.valueOf(product.getPrice())); // Convert double to String

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(product);
                }
            });
        }
    }
}
