package com.example.andrestaurant.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.andrestaurant.models.SoupComponents;
import com.example.andrestaurant.repositories.SoupComponentsRepository;

import java.util.List;

public class SoupActivityViewModel extends ViewModel {
    private MutableLiveData<List<SoupComponents>> mSoupComponents;
    private SoupComponentsRepository mRepo;
//    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if (mSoupComponents != null)
        {
            return;
        }
        mRepo = SoupComponentsRepository.getInstance();
        mSoupComponents = mRepo.getSoupComponents();
    }

    public LiveData<List<SoupComponents>> getNicePlaces()
    {
        return mSoupComponents;
    }


}
