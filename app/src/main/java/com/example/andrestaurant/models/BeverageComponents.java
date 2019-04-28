package com.example.andrestaurant.models;

public class BeverageComponents {

    private String title;

    private String imageUrl;

    public BeverageComponents(String imageUrl, String title)
    {
        this.title=title;
        this.imageUrl=imageUrl;
    }

    public BeverageComponents() {
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
