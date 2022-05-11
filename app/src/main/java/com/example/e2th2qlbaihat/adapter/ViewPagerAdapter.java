package com.example.e2th2qlbaihat.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.e2th2qlbaihat.fragment.FragmentList;
import com.example.e2th2qlbaihat.fragment.FragmentInfor;
import com.example.e2th2qlbaihat.fragment.FragmentSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentList();
            case 1:return new FragmentInfor();
            case 2:return new FragmentSearch();

        }
        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
