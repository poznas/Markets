package com.group.ig.markets;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.group.ig.markets.fragments.CountryPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MarketActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.container)
    ViewPager viewPager;
    @BindView(R.id.refresh_button)
    FloatingActionButton refreshButton;

    CountryPageAdapter countryPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        ButterKnife.bind(this);

        initializeViewPager(viewPager);
        setupCountryTabs(tabLayout);
        setRefreshButton(refreshButton);
    }

    private void setRefreshButton(FloatingActionButton refreshButton) {
        refreshButton.setOnClickListener(event -> {
            countryPageAdapter.refreshMarkets();
        });
    }

    private void initializeViewPager(ViewPager viewPager) {
        countryPageAdapter = new CountryPageAdapter(getSupportFragmentManager());
        countryPageAdapter.setCountries(Constants.countries);
        viewPager.setAdapter(countryPageAdapter);
    }

    private void setupCountryTabs(TabLayout tabLayout) {
        tabLayout.setupWithViewPager(viewPager);
    }
}
