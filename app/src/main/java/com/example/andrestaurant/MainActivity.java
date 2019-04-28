package com.example.andrestaurant;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.andrestaurant.adapters.PizzaAdapter;
import com.example.andrestaurant.models.PizzaComponents;
import com.example.andrestaurant.viewmodels.PizzaActivityViewModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //nav
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigation;
    //categories ids
    private ImageView pizza;
    private ImageView salad;
    private ImageView soup;
    private ImageView cake;
    private ImageView beverage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // nav menu
        initInstances();
        // end nav menu


        //pizzaIntent
        pizza = (ImageView) findViewById(R.id.pizza);
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pizzaActivity.class);
                startActivity(intent);
            }
        });
        //salad intent
        salad = findViewById(R.id.salad);
        salad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, saladActivity.class);
                startActivity(intent);
            }
        });
        //soup intent
        soup = findViewById(R.id.soup);
        soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, soupActivity.class);
                startActivity(intent);
            }
        });
        //cake intent
        cake = findViewById(R.id.cake);
        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cakeActivity.class);
                startActivity(intent);
            }
        });
        //beverage intent
        beverage = findViewById(R.id.beverage);
        beverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeverageActivity.class);
                startActivity(intent);
            }
        });
    }
    // method for nav
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // end
    private void initInstances() {


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.aboutus:
                        Intent i = new Intent(MainActivity.this, aboutusActivity.class);
                        startActivity(i);
                        break;
                    case R.id.register:
                        Intent e = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(e);
                        break;
                    case R.id.login:
                        Intent d = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(d);
                        break;
                    case R.id.signout:
                        FirebaseAuth.getInstance().signOut();
                        Intent f = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(f);
                        break;

                }
                return false;
            }
        });

    }

}
