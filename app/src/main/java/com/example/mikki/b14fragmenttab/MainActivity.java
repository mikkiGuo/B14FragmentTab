package com.example.mikki.b14fragmenttab;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    Toolbar toolbar;
    TabLayout tabLayout;
    TabLayout subtab_layout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        subtab_layout = findViewById(R.id.subtabLayout);
        viewPager = findViewById(R.id.pager);

        setSupportActionBar(toolbar);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Yellow"));
        tabLayout.addTab(tabLayout.newTab().setText("Purple"));
        tabLayout.addTab(tabLayout.newTab().setText("Orange"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setOnTabSelectedListener(this);
        subtab_layout.setVisibility(View.GONE);
        Pager myPager = new Pager(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(myPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position,0,true);
                tabLayout.setSelected(true);
                //subtab_layout.setVisibility(View.GONE);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void subtabForTabOne(){
        subtab_layout.addTab(subtab_layout.newTab().setText("one"));
        subtab_layout.addTab(subtab_layout.newTab().setText("two"));
        subtab_layout.addTab(subtab_layout.newTab().setText("three"));
        subtab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
    public void subtabForTabTwo(){
        subtab_layout.addTab(subtab_layout.newTab().setText("four"));
        subtab_layout.addTab(subtab_layout.newTab().setText("five"));
        subtab_layout.addTab(subtab_layout.newTab().setText("six"));
        subtab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
    }
    public void subtabForTabThree(){
        subtab_layout.addTab(subtab_layout.newTab().setText("seven"));
        subtab_layout.addTab(subtab_layout.newTab().setText("eight"));
        subtab_layout.addTab(subtab_layout.newTab().setText("night"));
        subtab_layout.setTabGravity(TabLayout.GRAVITY_FILL);
    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        subtab_layout.setVisibility(View.VISIBLE);

        int position = tab.getPosition();
        if(position == 0){
            subtabForTabOne();
        }
        if(position == 1){
            subtabForTabTwo();
        }
        if(position == 2){
            subtabForTabThree();
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        subtab_layout.removeAllTabs();


    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
