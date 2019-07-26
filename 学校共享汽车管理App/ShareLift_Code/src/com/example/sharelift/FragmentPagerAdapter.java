package com.example.sharelift;

import java.util.List;

import com.example.fragment.BaseFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private List<BaseFragment> fragments;

    public FragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.fragments = fragmentList;
    }


    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        return fragments.get(arg0);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        //super.destroyItem(container, position, object);
    }


}
