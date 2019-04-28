package com.example.andrestaurant.repositories;


import android.arch.lifecycle.MutableLiveData;

import com.example.andrestaurant.models.BeverageComponents;


import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class BeverageComponentsRepository {

    private static BeverageComponentsRepository instance;
    private ArrayList<BeverageComponents> dataSet = new ArrayList<>();

    public static BeverageComponentsRepository getInstance(){
        if(instance == null)
        {
            instance = new BeverageComponentsRepository();
        }
        return instance;
    }
    public MutableLiveData<List<BeverageComponents>> getBeverageComponents()
    {
        // retrieve data from webservice
        setBeverageComponents();

        MutableLiveData<List<BeverageComponents>> data = new MutableLiveData<>();
        // data set that should be retrieved from web api or database cache
        data.setValue(dataSet);
        return data;
    }

    private void setBeverageComponents()
    {
        dataSet.add(
                new BeverageComponents("https://www.avenuecalgary.com/wp-content/uploads/2019/01/AC_BeerAwards-7c69f48c.jpg",
                        "Water")
        );
        dataSet.add(
                new BeverageComponents("https://i0.wp.com/cupfulofkale.com/wp-content/uploads/2019/01/Orange-Carrot-and-Ginger-Juice.jpeg?resize=720%2C540&ssl=1",
                        "Juice")
        );
        dataSet.add(
                new BeverageComponents("https://www.avenuecalgary.com/wp-content/uploads/2019/01/AC_BeerAwards-7c69f48c.jpg",
                        "Beer")
        );
    }
}