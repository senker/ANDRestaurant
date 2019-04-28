package com.example.andrestaurant.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.andrestaurant.models.BeverageComponents;
import com.example.andrestaurant.repositories.BeverageComponentsRepository;

import java.util.List;


public class BeverageActivityViewModel extends ViewModel {
    private MutableLiveData<List<BeverageComponents>> mBeverageComponents;
    private BeverageComponentsRepository mRepo;

    public void init(){
        if (mBeverageComponents != null)
        {
            return;
        }
        mRepo = BeverageComponentsRepository.getInstance();
        mBeverageComponents = mRepo.getBeverageComponents();
    }


    public LiveData<List<BeverageComponents>> getNicePlaces()
    {
        return mBeverageComponents;
    }


}
