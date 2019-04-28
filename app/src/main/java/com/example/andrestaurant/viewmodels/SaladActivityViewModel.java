package com.example.andrestaurant.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.andrestaurant.models.PizzaComponents;
import com.example.andrestaurant.models.SaladComponents;
import com.example.andrestaurant.repositories.SaladComponentsRepository;

import java.util.List;

public class SaladActivityViewModel extends ViewModel {
    private MutableLiveData<List<SaladComponents>> mSaladComponents;
    private SaladComponentsRepository mRepo;


    public void init(){
        if (mSaladComponents != null)
        {
            return;
        }
        mRepo = SaladComponentsRepository.getInstance();
        mSaladComponents = mRepo.getSaladComponents();
    }

    public LiveData<List<SaladComponents>> getNicePlaces()
    {
        return mSaladComponents;
    }

}
