package com.example.myproject;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myproject.fragments.BusinessFragment;
import com.example.myproject.fragments.HealthFragment;
import com.example.myproject.fragments.ScienceFragment;
import com.example.myproject.fragments.SportFragment;
import com.example.myproject.fragments.TechnologyFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {



    private Context mcntext;


    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mcntext=context;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){

            case 0 :
                return new ScienceFragment();
            case 1:
                return new TechnologyFragment();
            case 2:
                return new BusinessFragment();
            case 3:
                return new HealthFragment() ;
            case 4:
                return new SportFragment();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        int titleResId;

        switch (position){

            case 0:
                titleResId = R.string.Science;
                break;
            case 1:
                titleResId = R.string.Technology;
                break;
            case 2:
                titleResId = R.string.Business;
                break;
            case 3:
                titleResId = R.string.Health;
                break;
            case 4:
                titleResId = R.string.Sport;
                break;


            default:
                titleResId = R.string.NotFounded;
                break;
        }


        return mcntext.getString(titleResId);
    }


}
