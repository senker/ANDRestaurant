package com.example.andrestaurant.models;

public class SaladComponents {

    private String saladTitle;

    private String saladImageUrl;

    public SaladComponents(String imageUrl, String title)
    {
        this.saladTitle=title;
        this.saladImageUrl=imageUrl;
    }

    public SaladComponents() {
    }

    public String getTitle() {
        return saladTitle;
    }

    public void setTitle(String title) {
        this.saladTitle = title;
    }

    public String getImageUrl() {
        return saladImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.saladImageUrl = imageUrl;
    }
}