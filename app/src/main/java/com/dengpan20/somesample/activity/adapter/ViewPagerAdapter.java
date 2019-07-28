package com.dengpan20.somesample.activity.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.dengpan20.somesample.bean.Tab;

import java.util.List;

/**
 * @author Paddy
 * @time 2019-07-28 22:27
 * @class describe
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<Tab > list;
    public ViewPagerAdapter(FragmentManager fm, List<Tab> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).getFragment();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
