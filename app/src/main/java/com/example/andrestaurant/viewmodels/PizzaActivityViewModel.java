package com.example.andrestaurant.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.andrestaurant.models.PizzaComponents;
import com.example.andrestaurant.repositories.PizzaComponentsRepository;

import java.util.List;

public class PizzaActivityViewModel extends ViewModel {
    private MutableLiveData<List<PizzaComponents>> mPizzaComponents;
    private PizzaComponentsRepository mRepo;

    public void init(){
        if (mPizzaComponents != null)
        {
            return;
        }
        mRepo = PizzaComponentsRepository.getInstance();
        mPizzaComponents = mRepo.getPizzaComponents();
    }

    public LiveData<List<PizzaComponents>> getNicePlaces()
    {
        return mPizzaComponents;
    }

}
