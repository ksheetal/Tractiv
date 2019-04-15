package com.example.tractiv;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int NumOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.NumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {

            case 0:
                SignupFragment signupFragment = new SignupFragment();
                return signupFragment;

            case 1:
               LoginFragment loginFragment = new LoginFragment();
                return loginFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }
}
