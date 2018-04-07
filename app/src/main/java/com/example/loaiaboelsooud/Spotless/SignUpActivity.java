package com.example.loaiaboelsooud.Spotless;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "MapsActivity";
    public static LatLng currentLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_signup);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_signup);
        initButtons();
        initView();
    }

    private void initButtons() {
        Button signUpB = findViewById(R.id.sign_up_button);
        Button chooseLocationB = findViewById(R.id.choose_location_button);
        chooseLocationB.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUpActivity.this, MapsActivity.class);
                        intent.putExtra("activity", "SignUpActivity");
                        startActivity(intent);
                    }
                }
        );
        signUpB.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUpActivity.this, MenuActivity.class);
                        intent.putExtra("activity", "SignUpActivity");
                        startActivity(intent);
                    }
                }
        );

    }

    private void initView() {
        Intent intent = getIntent();
        final String activity = intent.getStringExtra("activity");
        switch (activity) {
            case "ServiceProvider":
                Log.d(TAG, "initView: Service Provider");
                break;
            case "Client":
                Log.d(TAG, "initView: Client");
                break;
            default:
                Log.d(TAG, "Default");

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (currentLocation != null)
            getLocationName();
    }

    public void getLocationName() {

        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses;
            addresses = geocoder.getFromLocation(currentLocation.latitude, currentLocation.longitude, 1);
            String KnownName = addresses.get(0).getFeatureName();
            String Locality = addresses.get(0).getLocality();
            String SubAdminArea = addresses.get(0).getSubAdminArea();
            String CityName = addresses.get(0).getAdminArea();
            String CountryName = addresses.get(0).getCountryName();
            TextView defaultLocationView = (TextView) findViewById(R.id.defaultLocationView);
            defaultLocationView.setText(KnownName + " " + Locality + " " + SubAdminArea + " " + CityName + " " + CountryName);

        } catch (IOException e) {
            Log.d(TAG, "error");
            e.printStackTrace();
        }
    }

}
