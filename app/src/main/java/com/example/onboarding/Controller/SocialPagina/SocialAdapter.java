package com.example.onboarding.Controller.SocialPagina;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onboarding.R;

import java.util.ArrayList;

public class SocialAdapter extends BaseAdapter {
    private ArrayList<SocialModel> list;
    private LayoutInflater layoutInflater;

    public SocialAdapter(Context context, ArrayList<SocialModel> listData) {
        this.list = listData;
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

    public View getView(int position, View convertView, ViewGroup parent) {
        SocialAdapter.ViewHolder holder;
        if (convertView == null) {
            // Set the correct menu items styling
            convertView = layoutInflater.inflate(R.layout.activity_social_row, null);

            holder = new SocialAdapter.ViewHolder();

            // Define the fields which need to change based on input
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        } else {
            holder = (SocialAdapter.ViewHolder) convertView.getTag();
        }

        // Fill the items with the corresponding data.
        holder.title.setText(list.get(position).getTitle());
        holder.image.setImageResource(list.get(position).getImage());

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        ImageView image;
    }
}
