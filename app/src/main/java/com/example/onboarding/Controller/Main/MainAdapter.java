package com.example.onboarding.Controller.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.onboarding.R;

import java.util.ArrayList;


public class MainAdapter extends BaseAdapter {

    private ArrayList<MainModel> list;
    private LayoutInflater layoutInflater;

    public MainAdapter(Context context, ArrayList<MainModel> Users){
        this.list = Users;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        view = layoutInflater.inflate(R.layout.activity_main, null);
        TextView tvWelkom = (TextView) view.findViewById(R.id.tvWelcome);

        if(tvWelkom.getText() == "Welkom") {
            holder = new ViewHolder();
            holder.tvWelkom = view.findViewById(R.id.tvWelcome);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if (list.get(position).getID() == ""){
            holder.tvWelkom.setText("Welkom");
        } else {
            holder.tvWelkom.setText("Welkom" + list.get(position).getWelkom());
        }
        tvWelkom.setText(position);
        return view;
    }

    static class ViewHolder {
        TextView tvWelkom;
    }
}
