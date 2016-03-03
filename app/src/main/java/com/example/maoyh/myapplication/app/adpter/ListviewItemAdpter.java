package com.example.maoyh.myapplication.app.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maoyh.myapplication.app.R;

import java.util.List;


/**
 * Created by MAOYH on 2016/3/3.
 */
public class ListviewItemAdpter extends BaseAdapter {
    private List<String> data_title;
    private List<String> data_content;
    private List<Integer> data_icon;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListviewItemAdpter(Context context,List<String> data_title, List<String> data_content, List<Integer> data_icon ) {
        this.data_title = data_title;
        this.data_content = data_content;
        this.data_icon = data_icon;
        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data_title.size();
    }

    @Override
    public Object getItem(int i) {
        return data_title.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder ;
        if(view ==null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.listview_item,null);
            viewHolder.Icon = (ImageView) view.findViewById(R.id.iv_system_right);
            viewHolder.Title = (TextView) view.findViewById(R.id.tv_system_title);
            viewHolder.Content = (TextView) view.findViewById(R.id.tv_system_content);
            view.setTag(viewHolder);
        }else {viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.Icon.setBackgroundResource(data_icon.get(i));
        viewHolder.Title.setText( data_title.get(i));
        viewHolder.Content.setText( data_content.get(i));


        return view;
    }

    private static class ViewHolder {

        ImageView Icon;
        TextView Title;
        TextView Content;

    }
}
