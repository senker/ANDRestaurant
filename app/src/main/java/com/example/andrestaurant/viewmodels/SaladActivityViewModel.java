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
//    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if (mSaladComponents != null)
        {
            return;
        }
        mRepo = SaladComponentsRepository.getInstance();
        mSaladComponents = mRepo.getSaladComponents();
    }

//    public void addNewValue(final PizzaComponents nicePlace){
//        mIsUpdating.setValue(true);
//        // Creating Async task(not correct way to do it) to manually simulate a loading for 2 seconds
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected void onPostExecute(Void aVoid){
//                super.onPostExecute(aVoid);
//                List<PizzaComponents> currentPlaces = mPizzaComponents.getValue();
//                currentPlaces.add(nicePlace);
//                mPizzaComponents.postValue(currentPlaces);
//                mIsUpdating.postValue(false);
//            }
//
//            @Override
//            protected Void doInBackground(Void... voids) {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//
//        }.execute();
//
//
//    }

    public LiveData<List<SaladComponents>> getNicePlaces()
    {
        return mSaladComponents;
    }

//    public LiveData<Boolean> getIsUpdating(){
//        return mIsUpdating;
//    }

}
