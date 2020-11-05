package com.example.oderfood.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.oderfood.fragment.CategoryFragment;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
    public CategoryPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new CategoryFragment()
                ;
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(CategoryFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Object" + (position + 1);
    }
}
