package com.example.krid.ut9_test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Krid on 12/2/2558.
 */
public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i==0){
            return new tutorial1();
        }
        else if (i==1){
            return new tutorial2();
        }
        else if (i==2){
            return new tutorial3();
        }
        return new tutorial1();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
