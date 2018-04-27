package com.jrsosadev.greeter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class GreetPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Greet> greets;

    GreetPagerAdapter(FragmentManager fm, ArrayList<Greet> greets) {
        super(fm);
        this.greets = greets;
    }

    @Override
    public Fragment getItem(int position) {
        return GreetFragment.instance(greets.get(position));
    }

    @Override
    public int getCount() {
        return greets.size();
    }
}