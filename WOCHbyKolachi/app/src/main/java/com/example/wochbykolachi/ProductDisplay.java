package com.example.wochbykolachi;

public class ProductDisplay {
    private String name;
    private double price;
    private float rating;
    private String reviewPerson;
    private String reviews;
    private String description;

    public ProductDisplay(String name, double price, float rating, String reviewPerson, String reviews, String description) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.reviewPerson = reviewPerson;
        this.reviews = reviews;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return "$" + String.valueOf(price);
    }

    public float getRating() {
        return rating;
    }

    public String getReviewPerson() {
        return reviewPerson;
    }

    public String getReviews() {
        return reviews;
    }

    public String getDescription() {
        return description;
    }
}
