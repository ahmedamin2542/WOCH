package com.example.wochbykolachi;

public class CheckoutItem {
    private int imageResource;
    private String title;
    private String price;

    public CheckoutItem(int imageResource, String title, String price) {
        this.imageResource = imageResource;
        this.title = title;
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }
}
