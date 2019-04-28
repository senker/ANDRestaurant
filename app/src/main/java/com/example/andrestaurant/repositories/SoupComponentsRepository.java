package com.example.andrestaurant.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.andrestaurant.models.SoupComponents;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class SoupComponentsRepository {

    private static SoupComponentsRepository instance;
    private ArrayList<SoupComponents> dataSet = new ArrayList<>();

    public static SoupComponentsRepository getInstance(){
        if(instance == null)
        {
            instance = new SoupComponentsRepository();
        }
        return instance;
    }
    public MutableLiveData<List<SoupComponents>> getSoupComponents()
    {
        // retrieve data from webservice
        setSoupComponents();

        MutableLiveData<List<SoupComponents>> data = new MutableLiveData<>();
        // data set that should be retrieved from web api or database cache
        data.setValue(dataSet);
        return data;
    }

    private void setSoupComponents()
    {
        dataSet.add(
                new SoupComponents("https://www.fifteenspatulas.com/wp-content/uploads/2016/02/Chicken-Noodle-Soup-Fifteen-Spatulas-2.jpg",
                        "Chicken soup")
        );
        dataSet.add(
                new SoupComponents("https://simply-delicious-food.com/wp-content/uploads/2018/01/easy-vegetable-soup-1.jpg",
                        "Vegetable soup")
        );


    }
}