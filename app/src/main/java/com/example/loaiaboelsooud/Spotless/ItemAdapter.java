package com.example.loaiaboelsooud.Spotless;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by NAVY on 4/1/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] items;

    public ItemAdapter(Context context, String[] items) {

        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.costume_itemrow, parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Item) holder).textView.setText(items[position]);
        // ((Item) holder).stemPressingBox.setText(items[position]);
        //((Item) holder).dryCleanBox.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView textView;
        EditText itemsQuantity;
        CheckBox stemPressingBox, dryCleanBox;

        public Item(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
            stemPressingBox = itemView.findViewById(R.id.StemPressingBox);
            dryCleanBox = itemView.findViewById(R.id.DryCleanBox);
            itemsQuantity = itemView.findViewById(R.id.itemsQuantity);
        }
    }

}
