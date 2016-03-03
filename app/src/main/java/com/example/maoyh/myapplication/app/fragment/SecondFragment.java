package com.example.maoyh.myapplication.app.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.maoyh.myapplication.app.R;
import com.example.maoyh.myapplication.app.utils.RefreshLayout;

import java.util.ArrayList;

/**
 * Created by MAOYH on 2016/3/2.
 */
public class SecondFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,RefreshLayout.OnLoadListener  {
    private String mTitle;
    private RefreshLayout swipe_container;
    private ListView lv;
    private ArrayList<String> list;
    private ArrayAdapter<String> stringArrayAdapter;

    public static SecondFragment getInstance(String title) {
        SecondFragment sf = new SecondFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_secondfragment, null);
        //TextView card_title_tv = (TextView) v.findViewById(R.id.card_title_tv);
       // card_title_tv.setText(mTitle);
        swipe_container = (RefreshLayout) v.findViewById(R.id.swipe_container);
        lv = (ListView) v.findViewById(R.id.lv);
        initData();


        return v;
    }

    private void initData() {
        swipe_container.setOnRefreshListener(this);
        swipe_container.setOnLoadListener(this);
        list = new ArrayList<>();
        for (int i = 0;i<20;i++){
            list.add(i+"个数据");
        }
        stringArrayAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,list);
        lv.setAdapter(stringArrayAdapter);
        //设置刷新动画的颜色
        swipe_container.setColorSchemeResources(android.R.color.holo_purple, android.R.color.holo_blue_bright, android.R.color.holo_orange_light,
               android.R.color.holo_red_light);
    }


    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(0, "下拉刷新的数据");
                stringArrayAdapter.notifyDataSetChanged();
                //结束刷新 更改动画
                swipe_container.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onLoad() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(list.size(), "加载更多的数据");
                stringArrayAdapter.notifyDataSetChanged();
                //结束动画
                swipe_container.setLoading(false);

            }
        }, 2000);
    }
}
