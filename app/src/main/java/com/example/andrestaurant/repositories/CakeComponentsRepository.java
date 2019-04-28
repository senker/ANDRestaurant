package com.example.andrestaurant.repositories;


import android.arch.lifecycle.MutableLiveData;

import com.example.andrestaurant.models.CakeComponents;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class CakeComponentsRepository {

    private static CakeComponentsRepository instance;
    private ArrayList<CakeComponents> dataSet = new ArrayList<>();

    public static CakeComponentsRepository getInstance(){
        if(instance == null)
        {
            instance = new CakeComponentsRepository();
        }
        return instance;
    }
    public MutableLiveData<List<CakeComponents>> getCakeComponents()
    {
        // retrieve data from webservice
        setCakeComponents();

        MutableLiveData<List<CakeComponents>> data = new MutableLiveData<>();
        // data set that should be retrieved from web api or database cache
        data.setValue(dataSet);
        return data;
    }

    private void setCakeComponents()
    {
        dataSet.add(
                new CakeComponents("https://food-images.files.bbci.co.uk/food/recipes/easy_chocolate_cake_31070_16x9.jpg",
                        "Chocolate cake")
        );
        dataSet.add(
                new CakeComponents("https://img.taste.com.au/zCUJMoP6/taste/2016/11/bubblegum-rainbow-cake-91475-1.jpeg",
                        "Rainbow cake")
        );
        dataSet.add(
                new CakeComponents("https://timeincsecure-a.akamaihd.net/rtmp_uds/429048911/201801/2066/429048911_5706013914001_5703341808001-vs.jpg?pubId=429048911&videoId=5703341808001",
                        "Cheesecake")
        );

    }
}