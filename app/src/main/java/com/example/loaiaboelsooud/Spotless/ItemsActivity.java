package com.example.loaiaboelsooud.Spotless;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class
ItemsActivity extends AppCompatActivity {

    GridLayout relativeLayout;
    ViewGroup.LayoutParams StemPressingParams, DryCleanParams, viewDividerParams, QuanityOfItemsParams;
    CheckBox StemPressingBox, DryCleanBox;
    EditText QuanityOfItems;
    private static final String TAG = "MapsActivity";
    RecyclerView itemRecyclerView;
    String[] Items = {"item0", "item1", "item2", "item3", "item0", "item1", "item2", "item3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = findViewById(R.id.toolbar_items);
        setSupportActionBar(toolbar);
        //relativeLayout = findViewById(R.id.linear_main);
        itemRecyclerView = findViewById(R.id.itemrecycler);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRecyclerView.setAdapter(new ItemAdapter(this,Items));

    }
/*
    private void addQunatityBox() {
//TO BE TESTED
        QuanityOfItems = new EditText(this);
        QuanityOfItems.setInputType(InputType.TYPE_CLASS_NUMBER);
        //QuanityOfItems.setMaxEms(2);
        QuanityOfItems.setText("0");
        QuanityOfItemsParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        QuanityOfItems.setLayoutParams(QuanityOfItemsParams);
        // QuanityOfItemsParams.setMargins(802, (150 * i) + 90, 0, 0);
        // QuanityOfItems.setId(i);
        relativeLayout.addView(QuanityOfItems);
    }

    private void addDivider(int i) {

        View viewDivider = new View(this);
        viewDividerParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, (int) (getResources().getDisplayMetrics().density * 1));
        viewDivider.setLayoutParams(viewDividerParams);
        viewDivider.setBackgroundColor(Color.parseColor("#000000"));
        //  viewDividerParams.setMargins(0, (150 * i) + 90, 300, 0);
        relativeLayout.addView(viewDivider);
    }

    private void addCheckBox() {
        StemPressingParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        DryCleanParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


        // StemPressingParams.setMargins(300, (150 * i) + 90, 0, 0);
        //DryCleanParams.setMargins(600, (150 * i) + 90, 0, 0);
        StemPressingBox = new CheckBox(this);
        DryCleanBox = new CheckBox(this);
        // StemPressingBox.setId(i);
        // DryCleanBox.setId(i);
        StemPressingBox.setLayoutParams(StemPressingParams);
        DryCleanBox.setLayoutParams(DryCleanParams);
        //StemPressingBox.setText("check  1" + "  " + i);
        //DryCleanBox.setText("check  2" + "  " + i);
        StemPressingBox.setOnClickListener(getOnClickDoSomething(StemPressingBox));
        DryCleanBox.setOnClickListener(getOnClickDoSomething(DryCleanBox));
        relativeLayout.addView(StemPressingBox);
        relativeLayout.addView(DryCleanBox);
        //addQunatityBox();
        //  addDivider(i);


    }

    private void addView() {

        for (int i = 0; i < 20; i++) {
            addCheckBox();
            addQunatityBox();

        }
    }

    View.OnClickListener getOnClickDoSomething(final Button button) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("1");
                Log.d(TAG, "id: " + button.getId() + " text " + button.getText());

            }
        };
    }
*/
}
