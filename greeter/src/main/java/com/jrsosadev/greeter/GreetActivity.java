package com.jrsosadev.greeter;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.rd.PageIndicatorView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GreetActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    public static final String GREET_BUNDLE_EXTRA = "greet.bundle.extra";

    Bundle args;
    ViewPager mPager;
    Button greetEndButton;
    ArrayList<Greet> greets;
    PagerAdapter mPagerAdapter;
    PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet);
        greetEndButton = findViewById(R.id.greet_end_button);
        pageIndicatorView = findViewById(R.id.page_indicator_view);
        args = getIntent().getExtras();
        greets = getIntent().getParcelableArrayListExtra(GREET_BUNDLE_EXTRA);

        if (greets == null)
            throw new IllegalArgumentException("You must pass an ArrayList<Greet> with at least one Greet object in it as an Intent.extra using the GREET_BUNDLE_EXTRA as key");

        pageIndicatorView.setCount(greets.size());


        mPager = findViewById(R.id.pager);
        mPagerAdapter = new GreetPagerAdapter(getSupportFragmentManager(), greets);
        mPager.setAdapter(mPagerAdapter);
        mPager.addOnPageChangeListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        pageIndicatorView.setSelected(position);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
