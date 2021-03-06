package com.example.andrestaurant.models;

public class SoupComponents {

    private String title;

    private String imageUrl;

    public SoupComponents(String imageUrl, String title)
    {
        this.title=title;
        this.imageUrl=imageUrl;
    }

    public SoupComponents() {
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