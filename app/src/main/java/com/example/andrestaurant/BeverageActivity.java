package com.example.andrestaurant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrestaurant.adapters.BeverageAdapter;
import com.example.andrestaurant.models.BeverageComponents;
import com.example.andrestaurant.viewmodels.BeverageActivityViewModel;

import java.util.List;

public class BeverageActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BeverageAdapter mAdapter;
    private BeverageActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);
        //recycler view beverage
        mRecyclerView = findViewById(R.id.beverage_recycler);
        mMainActivityViewModel = ViewModelProviders.of(this).get(BeverageActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<BeverageComponents>>() {
            //override
            public void onChanged(@Nullable List<BeverageComponents> beverageComponents) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView()
    {
        mAdapter = new BeverageAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
