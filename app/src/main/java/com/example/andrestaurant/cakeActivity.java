package com.example.andrestaurant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrestaurant.adapters.CakeAdapter;
import com.example.andrestaurant.models.CakeComponents;
import com.example.andrestaurant.viewmodels.CakeActivityViewModel;

import java.util.List;

public class cakeActivity extends AppCompatActivity {
    //cake rec view
    private RecyclerView mRecyclerView;
    private CakeAdapter mAdapter;
    private CakeActivityViewModel mMainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake);

        //cake recycler view
        mRecyclerView = findViewById(R.id.cake_recycler);
        mMainActivityViewModel = ViewModelProviders.of(this).get(CakeActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<CakeComponents>>() {
            //override
            public void onChanged(@Nullable List<CakeComponents> pizzaComponents) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView()
    {
        mAdapter = new CakeAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
