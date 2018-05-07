package com.group.ig.markets.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.group.ig.markets.beans.Country;

import java.util.ArrayList;
import java.util.List;


public class CountryPageAdapter extends FragmentStatePagerAdapter {


    private List<CountryFragment> fragments = new ArrayList<>();
    private List<Country> countries;

    public CountryPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
        for( Country country : countries){
            CountryFragment fragment = new CountryFragment();
            fragment.setProperties(country);
            fragments.add(fragment);
        }
    }

    public void refreshMarkets(){
        for( CountryFragment fragment : fragments){
            fragment.refreshMarkets();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return countries.get(position).getDisplayName();
    }
}
