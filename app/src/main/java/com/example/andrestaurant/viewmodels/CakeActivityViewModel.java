package com.example.andrestaurant.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.andrestaurant.models.CakeComponents;
import com.example.andrestaurant.repositories.CakeComponentsRepository;

import java.util.List;

public class CakeActivityViewModel extends ViewModel {
    private MutableLiveData<List<CakeComponents>> mCakeComponents;
    private CakeComponentsRepository mRepo;
//    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if (mCakeComponents != null)
        {
            return;
        }
        mRepo = CakeComponentsRepository.getInstance();
        mCakeComponents = mRepo.getCakeComponents();
    }


    public LiveData<List<CakeComponents>> getNicePlaces()
    {
        return mCakeComponents;
    }

}
