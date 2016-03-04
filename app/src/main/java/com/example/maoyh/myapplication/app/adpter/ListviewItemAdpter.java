package com.example.maoyh.myapplication.app.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maoyh.myapplication.app.R;
import com.example.maoyh.myapplication.app.entity.ListEntity;

import java.util.List;


/**
 * Created by MAOYH on 2016/3/3.
 */
public class ListviewItemAdpter extends BaseAdapter {
    private List<ListEntity> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public ListviewItemAdpter(Context context, List<ListEntity> data) {
        this.data = data;

        this.context = context;
        this.layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.listview_item, null);
            viewHolder.Icon = (ImageView) view.findViewById(R.id.iv_system_right);
            viewHolder.Title = (TextView) view.findViewById(R.id.tv_system_title);
            viewHolder.Content = (TextView) view.findViewById(R.id.tv_system_content);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.Icon.setBackgroundResource(data.get(i).getIcon());
        viewHolder.Title.setText(data.get(i).getTitle());
        viewHolder.Content.setText(data.get(i).getContent());


        return view;
    }

    private static class ViewHolder {

        ImageView Icon;
        TextView Title;
        TextView Content;

    }
}
