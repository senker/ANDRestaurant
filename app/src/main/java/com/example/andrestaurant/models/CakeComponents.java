package com.example.andrestaurant.models;

public class CakeComponents {

    private String title;

    private String imageUrl;

    public CakeComponents(String imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public CakeComponents() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}