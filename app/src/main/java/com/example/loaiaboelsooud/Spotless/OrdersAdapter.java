package com.example.loaiaboelsooud.Spotless;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by NAVY on 4/1/2018.
 */

public class OrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] orders;

    public OrdersAdapter(Context context, String[] orders) {

        this.context = context;
        this.orders = orders;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.costume_orderrow, parent, false);
        Order order = new Order(row);
        return order;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((OrdersAdapter.Order) holder).textView.setText(orders[position]);
    }

    @Override
    public int getItemCount() {
        return orders.length;
    }

    public class Order extends RecyclerView.ViewHolder {
        TextView textView;


        public Order(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.order);

        }
    }

}
