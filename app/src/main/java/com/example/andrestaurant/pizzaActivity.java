package com.example.andrestaurant;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrestaurant.adapters.PizzaAdapter;
import com.example.andrestaurant.models.PizzaComponents;
import com.example.andrestaurant.viewmodels.PizzaActivityViewModel;

import java.util.List;

public class pizzaActivity extends AppCompatActivity {
    //pizza rec view
    private RecyclerView mRecyclerView;
    private PizzaAdapter mAdapter;
    private PizzaActivityViewModel mMainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_list);
        //recyclerviewpizza
        mRecyclerView = findViewById(R.id.pizza_recycler);
        mMainActivityViewModel = ViewModelProviders.of(this).get(PizzaActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<PizzaComponents>>() {
            //override
            public void onChanged(@Nullable List<PizzaComponents> pizzaComponents) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    // method for initiation recycler view pizza
    private void initRecyclerView()
    {
        mAdapter = new PizzaAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
