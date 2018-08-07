package com.example.surainrsinnasamy.makingminiproject;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PokemonPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    //Constructor
    public PokemonPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //This determines fragment for each pages
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PokemonListViewFragment();
            case 1:
                return new MainPokemonListFragment();
            case 2:
                return new CreatePokemonFragment();
        }
        return null;
    }

    //This determines number of pages
    @Override
    public int getCount() {
        return 3;
    }

    //This generates title based on item position
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "ListView Pokemon Information";
            case 1:
                return "RecycleView Pokemon Information";
            case 2:
                return "Create Pokemon";
            default:
                return null;
        }
    }
}
