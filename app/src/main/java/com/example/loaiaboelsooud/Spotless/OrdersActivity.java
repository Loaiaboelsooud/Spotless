package com.example.loaiaboelsooud.Spotless;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class OrdersActivity extends AppCompatActivity {

    private static final String TAG = "MapsActivity";
    String[] Orders = {"item0", "item1", "item2", "item3", "item4", "item1", "item2", "item3"};
    RecyclerView orderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_orders);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        orderRecyclerView = findViewById(R.id.orderecycler);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        orderRecyclerView.setAdapter(new OrdersAdapter(this, Orders));
        ImageButton ordersActivityBackB = findViewById(R.id.order_toolbar_backbutton);
        ordersActivityBackB .setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                     OrdersActivity.super.onBackPressed();
                    }
                }
        );

    }

}
