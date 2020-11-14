package com.example.oderfood.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.oderfood.fragment.AllFoodFragment;
import com.example.oderfood.fragment.AppetizerFragment;
import com.example.oderfood.fragment.GrilledFragment;
import com.example.oderfood.fragment.HotPotFragment;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
    public CategoryPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 1:
                return new GrilledFragment();
            case 2:
                return new HotPotFragment();
            case 3:
                return new AppetizerFragment();
            default:
                return new AllFoodFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 1:
                return "Appetizer";
            case 2:
                return "Grilled";
            case 3:
                return "HotPot";
            default:
                return "All";
        }
    }
}
