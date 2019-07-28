package com.dengpan20.somesample.bean;

import androidx.fragment.app.Fragment;

import java.util.List;

/**
 * @author Paddy
 * @time 2019-07-28 22:29
 * @class describe
 */
public class Tab {
    private Fragment fragment;
    private String title;

    public Tab(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
