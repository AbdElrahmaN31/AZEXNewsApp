package com.example.myproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myproject.List.NewAdapter;
import com.example.myproject.Models.Articles;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;
    ViewPager viewPager;
    Context context;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigition_drawer);

        tabLayout=findViewById(R.id.tabLayout_id);
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),this);
        viewPager=findViewById(R.id.viewPager_id);
        toolbar=findViewById(R.id.toolBar_id);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);



        // this to open navigationDrawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_navigation, R.string.close_navigation);
        drawerLayout.addDrawerListener((toggle));

        toggle.syncState();

        // to add on_click_listener to navigation drawer
        navigationView.setNavigationItemSelectedListener(this);



    }

    // method onBack that when I click back if navigation is opened , navigation closed first then close application
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {


            super.onBackPressed();

        }
    }

    // method on click listener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.business_id:

viewPager.setCurrentItem(0);
                break;

            case R.id.health_id:

                viewPager.setCurrentItem(2);

                break;

            case R.id.science_id:

                viewPager.setCurrentItem(3);

                break;case R.id.sport_id:

                viewPager.setCurrentItem(4);

                break;case R.id.tecnology_id:

                viewPager.setCurrentItem(5);

                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;

    }


        }

