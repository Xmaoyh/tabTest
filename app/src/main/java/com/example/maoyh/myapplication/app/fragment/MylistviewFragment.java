package com.example.maoyh.myapplication.app.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.maoyh.myapplication.app.R;
import com.example.maoyh.myapplication.app.adpter.ListviewItemAdpter;
import com.example.maoyh.myapplication.app.entity.ListEntity;
import com.example.maoyh.myapplication.app.utils.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAOYH on 2016/3/3.
 */
public class MylistviewFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, RefreshLayout.OnLoadListener {

    private RefreshLayout swipe_container;
    private ListView lv;
    private List<ListEntity> data;
    private ListviewItemAdpter mlistViewAdpter;


    public static MylistviewFragment getInstance() {
        MylistviewFragment mf = new MylistviewFragment();

        return mf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_listviewfragment, null);
        swipe_container = (RefreshLayout) v.findViewById(R.id.swipe_container_list);
        lv = (ListView) v.findViewById(R.id.lv_list);
        initData();
        return v;
    }

    private void initData() {
        swipe_container.setOnRefreshListener(this);
        swipe_container.setOnLoadListener(this);
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new ListEntity(R.mipmap.ic_launcher, i + "个新闻标题", i + "个新闻内容"));
        }
        mlistViewAdpter = new ListviewItemAdpter(getActivity(), data);
        lv.setAdapter(mlistViewAdpter);
        //设置刷新动画的颜色
        swipe_container.setColorSchemeResources(android.R.color.holo_purple, android.R.color.holo_blue_bright, android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.add(0, new ListEntity(R.mipmap.ic_launcher, "增加新闻标题", "增加新闻内容"));
                mlistViewAdpter.notifyDataSetChanged();
                //结束刷新 更改动画
                swipe_container.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.add(new ListEntity(R.mipmap.ic_launcher, "增加新闻标题", "增加新闻内容"));
                mlistViewAdpter.notifyDataSetChanged();
                //结束动画
                swipe_container.setLoading(false);

            }
        }, 2000);
    }
}
