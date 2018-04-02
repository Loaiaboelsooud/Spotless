package com.example.loaiaboelsooud.Spotless;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


public class ItemsActivity extends AppCompatActivity {

    private static final String TAG = "MapsActivity";
    RecyclerView itemRecyclerView;
    String[] Items = {"item0", "item1", "item2", "item3", "item4", "item5", "item6", "item7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = findViewById(R.id.toolbar_items);
        setSupportActionBar(toolbar);
        itemRecyclerView = findViewById(R.id.itemrecycler);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRecyclerView.setAdapter(new ItemAdapter(this, Items));

    }

 /*
checkbox click listener
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
