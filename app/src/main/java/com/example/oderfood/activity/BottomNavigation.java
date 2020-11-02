package com.example.oderfood.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.oderfood.R;
import com.example.oderfood.adapter.ViewPagerAdapter;
import com.example.oderfood.fragment.CategoryFragment;
import com.example.oderfood.fragment.HistoryFragment;
import com.example.oderfood.fragment.HomeFragment;
import com.example.oderfood.fragment.ProfileFragment;
import com.example.oderfood.fragment.TableFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomNavigation;
    private ViewPager viewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        mBottomNavigation = findViewById(R.id.buttom_navigation);
        mBottomNavigation.setOnNavigationItemSelectedListener(this);

        viewPager = findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mBottomNavigation.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigation.getMenu().findItem(R.id.table).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigation.getMenu().findItem(R.id.category).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigation.getMenu().findItem(R.id.notification).setChecked(true);
                        break;
                    case 4:
                        mBottomNavigation.getMenu().findItem(R.id.profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_frame_layout, fragment);
            ft.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.table:
                viewPager.setCurrentItem(1);
                break;
            case R.id.category:
                viewPager.setCurrentItem(2);
                break;
            case R.id.notification:
                viewPager.setCurrentItem(3);
                break;
            case R.id.profile:
                viewPager.setCurrentItem(4);
                break;
        }
        return loadFragment(fragment);
    }
}