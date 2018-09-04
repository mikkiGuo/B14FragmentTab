package com.example.mikki.b14fragmenttab;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;


public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    //get the fragment based on position
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs

        switch (position) {
            case 0:
                TabOneBody tab1 = new TabOneBody();
                return tab1;
            case 1:
                TabTwoBody tab2 = new TabTwoBody();
                return tab2;
            case 2:
                TabThreeBody tab3 = new TabThreeBody();
                return tab3;
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
