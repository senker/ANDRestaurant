package com.example.andrestaurant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrestaurant.adapters.SoupAdapter;
import com.example.andrestaurant.models.SoupComponents;
import com.example.andrestaurant.viewmodels.SoupActivityViewModel;

import java.util.List;

public class soupActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SoupAdapter mAdapter;
    private SoupActivityViewModel mMainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);
        //soup recycler view
        mRecyclerView = findViewById(R.id.soup_recycler);
        mMainActivityViewModel = ViewModelProviders.of(this).get(SoupActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<SoupComponents>>() {
            //override
            public void onChanged(@Nullable List<SoupComponents> pizzaComponents) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView()
    {
        mAdapter = new SoupAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
