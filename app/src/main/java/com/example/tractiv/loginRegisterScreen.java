package com.example.tractiv;

import android.support.constraint.solver.widgets.ConstraintTableLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class loginRegisterScreen extends AppCompatActivity {

   public TabLayout tabLayout;
   private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register_screen);

        tabLayout =  findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);

        tabLayout.addTab(tabLayout.newTab().setText("Sign up"));
        tabLayout.addTab(tabLayout.newTab().setText("Log in"));

       // final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final com.example.tractiv.PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}


