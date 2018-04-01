package com.example.loaiaboelsooud.Spotless;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;




public class OrdersActivity extends AppCompatActivity {
    String[] Orders = {"item0", "item1", "item2", "item3", "item0", "item1", "item2", "item3"};
    RecyclerView orderRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_orders);
        setSupportActionBar(toolbar);
        orderRecyclerView = findViewById(R.id.orderecycler);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerView.setAdapter(new OrdersAdapter(this,Orders));



    }

}
