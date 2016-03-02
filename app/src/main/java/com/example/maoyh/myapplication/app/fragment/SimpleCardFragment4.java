package com.example.maoyh.myapplication.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maoyh.myapplication.app.R;
import com.example.maoyh.myapplication.app.adpter.MyPagerAdapter;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;


/**
 * Created by MAOYH on 2016/3/2.
 */
public class SimpleCardFragment4 extends Fragment {
    private ArrayList<Fragment> mFragments;
    private String[] mTitles = {"已付款", "未付款",};
    private ViewPager mViewPager;
    private SegmentTabLayout mTabLayout;

    public static SimpleCardFragment4 getInstance() {
        SimpleCardFragment4 sf = new SimpleCardFragment4();

        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment4, null);
        mTabLayout = (SegmentTabLayout) v.findViewById(R.id.tl_1);
        mFragments = new ArrayList<>();
        for (String title : mTitles) {
            mFragments.add(SecondFragment.getInstance("Switch ViewPager " + title));
        }
        mViewPager = (ViewPager)v.findViewById(R.id.vp4);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager(),mFragments,mTitles));
        mTabLayout.setTabData(mTitles);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setCurrentItem(1);


        return v;
    }

}