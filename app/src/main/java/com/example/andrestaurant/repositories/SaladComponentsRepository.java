package com.example.andrestaurant.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.andrestaurant.models.SaladComponents;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton pattern
 */
public class SaladComponentsRepository {

    private static SaladComponentsRepository instance;
    private ArrayList<SaladComponents> dataSet = new ArrayList<>();

    public static SaladComponentsRepository getInstance(){
        if(instance == null)
        {
            instance = new SaladComponentsRepository();
        }
        return instance;
    }
    public MutableLiveData<List<SaladComponents>> getSaladComponents()
    {
        // retrieve data from webservice
        setSaladComponents();

        MutableLiveData<List<SaladComponents>> data = new MutableLiveData<>();
        // data set that should be retrieved from web api or database cache
        data.setValue(dataSet);
        return data;
    }

    private void setSaladComponents()
    {
        dataSet.add(
                new SaladComponents("https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Caesar_salad_%282%29.jpg/1200px-Caesar_salad_%282%29.jpg",
                        "Caesar salad")
        );
        dataSet.add(
                new SaladComponents("https://www.radacutlery.com/wp-content/uploads/2016/05/Berry-Blue-Summer-Salad-1080x675.jpg",
                        "Summer salad")
        );
        dataSet.add(
                new SaladComponents("https://cookieandkate.com/images/2018/02/chopped-greek-salad-with-homemade-greek-vinaigrette.jpg",
                        "Greek salad")
        );


    }
}