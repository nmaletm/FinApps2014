package com.inteam.estrellawallet.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inteam.estrellawallet.HistoryActivity;
import com.inteam.estrellawallet.MyCatalogActivity;
import com.inteam.estrellawallet.R;
import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.entities.Expense;
import com.inteam.estrellawallet.domain.managers.UserManager;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HistoryAdapter extends BaseAdapter{

    private HistoryActivity mContext;
    public List<Expense> items;


    public HistoryAdapter(HistoryActivity activity, List<Expense> newItems) {
        mContext = activity;
        items = newItems;
        UserManager um = new UserManager(activity.getApplicationContext());
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolderItem holder;
        if(convertView == null){
            LayoutInflater vi = LayoutInflater.from(this.mContext);
            holder = new ViewHolderItem();
            convertView = vi.inflate(R.layout.list_history, null);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolderItem) convertView.getTag();
        }
        final Expense item = items.get(position);
        if (item != null) {
            holder.background = (LinearLayout) convertView.findViewById(R.id.LL_achievement);
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            holder.name.setText(item.getCategory());
            holder.price = (TextView) convertView.findViewById(R.id.item_level);
            holder.price.setText(item.getAmount()+" €");
            holder.date = (TextView) convertView.findViewById(R.id.item_date);
            holder.date.setText(new SimpleDateFormat("dd/MM/yyyy").format(item.getDate()));
        }
        return convertView;
    }
}