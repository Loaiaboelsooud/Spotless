package com.example.loaiaboelsooud.Spotless;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "relativeLayout";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MapsActivity m = new MapsActivity();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        Button stbutton = findViewById(R.id.SignInB);
        stbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                        intent.putExtra("activity", "MainActivity");
                        startActivity(intent);
                    }
                }
        );
        Button ndbutton = findViewById(R.id.WorkWithUsB);
        ndbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, OrdersActivity.class);
                        //intent.putExtra("activity", "MenuActivity");
                        startActivity(intent);
                    }
                }
        );

    }

}
