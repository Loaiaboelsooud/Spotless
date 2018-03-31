package com.example.loaiaboelsooud.Spotless;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ItemsActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    LinearLayout.LayoutParams StemPressingParams, DryCleanParams, viewDividerParams, QuanityOfItemsParams;
    CheckBox StemPressingBox, DryCleanBox;
    EditText QuanityOfItems;
    private static final String TAG = "MapsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = findViewById(R.id.toolbar_items);
        setSupportActionBar(toolbar);
        relativeLayout = findViewById(R.id.linear_main);
        addCheckBox();
        Log.d(TAG, "onCreate: yasater");
    }

    private void addQunatityBox(int i) {
//TO BE TESTED
        QuanityOfItems = new EditText(this);
        QuanityOfItems.setInputType(InputType.TYPE_CLASS_NUMBER);
        //QuanityOfItems.setMaxEms(2);
        QuanityOfItems.setText("0");
        QuanityOfItemsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        QuanityOfItemsParams.setMargins(802, (150 * i) + 90, 0, 0);
        QuanityOfItems.setId(i);
        relativeLayout.addView(QuanityOfItems, QuanityOfItemsParams);
    }

    private void addDivider(int i) {

        View viewDivider = new View(this);
        viewDividerParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, (int) (getResources().getDisplayMetrics().density * 1));
        viewDivider.setBackgroundColor(Color.parseColor("#000000"));
        viewDividerParams.setMargins(0, (150 * i) + 90, 300, 0);
        relativeLayout.addView(viewDivider, viewDividerParams);
    }

    private void addCheckBox() {
        StemPressingParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        DryCleanParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < 20; i++) {
            Log.d(TAG, "addCheckBox: " + i);
            StemPressingParams.setMargins(300, (150 * i) + 90, 0, 0);
            DryCleanParams.setMargins(600, (150 * i) + 90, 0, 0);
            StemPressingBox = new CheckBox(this);
            DryCleanBox = new CheckBox(this);
            StemPressingBox.setId(i);
            DryCleanBox.setId(i);
            //StemPressingBox.setText("check  1" + "  " + i);
            //DryCleanBox.setText("check  2" + "  " + i);
            StemPressingBox.setOnClickListener(getOnClickDoSomething(StemPressingBox));
            DryCleanBox.setOnClickListener(getOnClickDoSomething(DryCleanBox));
            relativeLayout.addView(StemPressingBox, StemPressingParams);
            relativeLayout.addView(DryCleanBox, DryCleanParams);
            addQunatityBox(i);
            addDivider(i);

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

}
