package com.example.andrestaurant.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.andrestaurant.models.PizzaComponents;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class PizzaComponentsRepository {

    private static PizzaComponentsRepository instance;
    private ArrayList<PizzaComponents> dataSet = new ArrayList<>();

    public static PizzaComponentsRepository getInstance(){
        if(instance == null)
        {
            instance = new PizzaComponentsRepository();
        }
        return instance;
    }
    // pretend to get data from a webservice or online source
    public MutableLiveData<List<PizzaComponents>> getPizzaComponents()
    {
        // retrieve data from webservice
        setPizzaComponents();

        MutableLiveData<List<PizzaComponents>> data = new MutableLiveData<>();
        // data set that should be retrieved from web api or database cache
        data.setValue(dataSet);
        return data;
    }

    private void setPizzaComponents()
    {
        dataSet.add(
                new PizzaComponents("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new PizzaComponents("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new PizzaComponents("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new PizzaComponents("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );

        dataSet.add(
                new PizzaComponents("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new PizzaComponents("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new PizzaComponents("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}