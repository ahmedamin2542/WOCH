package com.example.wochbykolachi;

public class WOCHMenuProduct {
    private double price;
    private int image;
    private String title;

    public WOCHMenuProduct(int image, String title, double price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return "$" +price;
    }

    public void setDescription(int price) {
        this.price = price;
    }
}
