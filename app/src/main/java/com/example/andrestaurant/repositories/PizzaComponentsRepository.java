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
                new PizzaComponents("https://cdn-image.foodandwine.com/sites/default/files/styles/medium_2x/public/200703-r-xl-perfect-pizza-margherita.jpg?itok=aX-nsHDP",
                        "Margarita")
        );
        dataSet.add(
                new PizzaComponents("https://img.stpu.com.br/?img=https://s3.amazonaws.com/pu-mgr/default/a0R0f00000xpZ9zEAE/5a971cdae4b0d5230b707b28.jpg&w=620&h=400",
                        "Napolitana")
        );
        dataSet.add(
                new PizzaComponents("https://media-cdn.tripadvisor.com/media/photo-s/13/18/3b/06/pizza-capricciosa.jpg",
                        "Capriciosa")
        );
        dataSet.add(
                new PizzaComponents("https://papasitalianrecipes.com/wp-content/uploads/2014/02/quattro-formaggio.jpg",
                        "4 Cheeses")
        );

        dataSet.add(
                new PizzaComponents("https://s3-media4.fl.yelpcdn.com/bphoto/_pUy9RMXKrQtEkMVXp9xDA/o.jpg",
                        "Diablo")
        );
        dataSet.add(
                new PizzaComponents("https://assets3.thrillist.com/v1/image/2783327/size/tmg-article_default_mobile.jpg",
                        "Pepperoni")
        );

    }
}