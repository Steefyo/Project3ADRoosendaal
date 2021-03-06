package com.example.onboarding.Controller.MenuPagina;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onboarding.R;

public class MenuAdapter extends BaseAdapter {
    private ArrayList<MenuModel> list;
    private LayoutInflater layoutInflater;

    public MenuAdapter(Context context, ArrayList<MenuModel> listData) {
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
        ViewHolder holder;
        if (convertView == null) {
            // Set the correct menu items styling
            convertView = layoutInflater.inflate(R.layout.activity_menu_row, null);

            holder = new ViewHolder();

            // Define the fields which need to change based on input
            holder.image = convertView.findViewById(R.id.image);
            holder.title = convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Fill the items with the corresponding data.
        holder.title.setText(list.get(position).getTitle());
        holder.image.setImageResource(list.get(position).getImage());

        // Change color based on status
        if (list.get(position).getStatus() == 0) {
            holder.title.setBackgroundColor(Color.argb(66, 16, 85, 172));   // Blue
        } else {
            holder.title.setBackgroundColor(Color.argb(66, 16, 172, 35));   // Green
        }

        return convertView;
    }

    static class ViewHolder {
        TextView title;
        ImageView image;
    }

}
