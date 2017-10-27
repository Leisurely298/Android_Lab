package com.example.administrator.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<NameMenu>list;

    public MyAdapter(Context context, List<NameMenu> list){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(list == null){
            return 0;
        }
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if (list == null){
            return null;
        }
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View convertView ;
        ViewHolder viewHolder;
        if(view == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            viewHolder.first_letter = (TextView)convertView.findViewById(R.id.first_letter);
            convertView.setTag(viewHolder);
        } else{
            convertView = view;
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.price.setText(list.get(i).getPrice());
        viewHolder.first_letter.setText(list.get(i).getFirst_Letter());
        return  convertView;
    }

    private class ViewHolder{
        public TextView name;
        public TextView price;
        public TextView first_letter;
    }
}
