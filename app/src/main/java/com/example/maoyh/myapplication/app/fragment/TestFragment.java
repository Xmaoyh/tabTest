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
import android.widget.Spinner;
import android.widget.TextView;

import com.example.maoyh.myapplication.app.R;

/**
 * Created by MAOYH on 2016/3/4.
 */
public class TestFragment extends Fragment {
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
}
