package com.example.andrestaurant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andrestaurant.adapters.SaladAdapter;
import com.example.andrestaurant.models.SaladComponents;
import com.example.andrestaurant.viewmodels.SaladActivityViewModel;

import java.util.List;

public class saladActivity extends AppCompatActivity {

    //salad rec view
    private RecyclerView mRecyclerView;
    private SaladAdapter mAdapter;
    private SaladActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);
        //salad rec view
        mRecyclerView = findViewById(R.id.salad_recycler);
        mMainActivityViewModel = ViewModelProviders.of(this).get(SaladActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<SaladComponents>>() {
            //override
            public void onChanged(@Nullable List<SaladComponents> saladComponents) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView()
    {
        mAdapter = new SaladAdapter(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
