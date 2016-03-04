package com.example.maoyh.myapplication.app.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.maoyh.myapplication.app.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MAOYH on 2016/3/4.
 */
public class TestFragment extends Fragment {
    private GridView gridView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> gridviewData;
    private int[] icon = {R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private String[] text = {"待接单","开单","物流查询","待接送货","库存/配载","车辆跟踪"};
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter arrayAdapter;
    private Spinner spinner;
    private TextView textView;
    private String city,name,show;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =   inflater.inflate(R.layout.layout_test_fragment,null);
        autoCompleteTextView = (AutoCompleteTextView) v.findViewById(R.id.autotext);
        textView = (TextView) v.findViewById(R.id.tv_show);
        spinner = (Spinner) v.findViewById(R.id.spinner);
        gridView = (GridView) v.findViewById(R.id.mygrid);
        getGridviewData();
        simpleAdapter = new SimpleAdapter(getContext(),getGridviewData(),R.layout.gridview_item,text,icon);
        gridView.setAdapter(simpleAdapter);
        arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.data_autoText));
        //设置输入第一个字符就进行提示
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city = spinner.getSelectedItem().toString();
                name = autoCompleteTextView.getText().toString();
                textView.setText(city + name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                city = spinner.getSelectedItem().toString();
                name = autoCompleteTextView.getText().toString();
                textView.setText(city + name);
            }
        });

        return  v;
    }

    private List<Map<String, Object>> getGridviewData() {
        for(int i = 0;i < icon.length;i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("iamge",icon[i]);
            map.put("text",text[i]);
            gridviewData.add(map);
        }
        return gridviewData;
    }
}
