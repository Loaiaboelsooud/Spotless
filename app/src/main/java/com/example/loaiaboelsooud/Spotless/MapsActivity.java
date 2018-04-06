package com.example.loaiaboelsooud.Spotless;

import android.*;
import android.Manifest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import static java.lang.Boolean.TRUE;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener {
    private Location currentLocation;
    public LatLng latLngs;
    private static final String TAG = "MapsActivity";
    private boolean mapInt = false;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;

    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        if (CheckGpsStatus()) {
            getLocationPermission();
        } else {
            GpsDirect();

        }
        //  addFragment();
    }


    public MapsActivity() {
        super();
    }

  /*  private void addFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MapFragment MixFragment = new MapFragment();
        fragmentTransaction.add(R.id.fragment_map, MixFragment);
        fragmentTransaction.commit();

    }*/

    @Override
    protected void onResume() {
        //to be tested

        super.onResume();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!mapInt) {

                    if (CheckGpsStatus()) {
                        getLocationPermission();
                    }
                }
            }
        }, 10000);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");

        mMap = googleMap;

        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }

            mMap.setOnMyLocationButtonClickListener(this);
        }

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng position) {

                Marker(position);

            }
        });
    }


    private void getDeviceLocation() {
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try {
            if (mLocationPermissionsGranted) {

                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful() && (Location) task.getResult() != null) {
                            Log.d(TAG, "onComplete: found location!");
                            currentLocation = (Location) task.getResult();

                            //el marker bayndh el camera
                            Marker(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()));

                            //lw 3ayz el camera heya el tetndahaa
                            /*  moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM);*/

                            Log.d(TAG, "onComplete: found location!");
                            mMap.setMyLocationEnabled(true);
                            mMap.getUiSettings().setMyLocationButtonEnabled(true);
                            initButton();
                        } else {
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        } catch (SecurityException e) {
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage());
        }
    }


    private void Marker(LatLng currentLocation) {

        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(currentLocation).draggable(true));
        moveCamera(currentLocation, DEFAULT_ZOOM);

        //ta7rak el marker manually
        /*        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            @Override
            public void onMarkerDragStart(Marker marker) {
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                Log.d(TAG, "latitude : " + marker.getPosition().latitude);
                marker.setSnippet(String.valueOf(marker.getPosition().latitude));
                mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));

            }

            @Override
            public void onMarkerDrag(Marker marker) {
            }

        });
*/
    }

    private void moveCamera(LatLng latLng, float zoom) {

        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
        latLngs = latLng;

    }

    private void initMap() {
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(MapsActivity.this);

    }

    private void initButton() {
        Button mapButton = findViewById(R.id.MapB);
        mapButton.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        final String activity = intent.getStringExtra("activity");

        switch (activity) {
            case "SignUpActivity":
                mapButton.setText("proceed");
                break;
            default:
                Log.d(TAG, "Default");

        }
        mapButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        switch (activity) {
                            case "SignUpActivity":

                                Location location = new Location("location");
                                location.setLatitude(latLngs.latitude);
                                location.setLongitude(latLngs.longitude);
                                SignUpActivity.currentLocation = location;
                                Intent intent2 = new Intent(MapsActivity.this, SignUpActivity.class);
                                //intent.putExtra("activity", "MenuActivity");
                                startActivity(intent2);
                                break;
                            default:
                                Log.d(TAG, "Default");
                        }
                    }
                }
        );
    }

    private void getLocationPermission() {
        mapInt = TRUE;
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionsGranted = true;
                initMap();
            } else {
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    Context context;
    LocationManager locationManager;


    public boolean CheckGpsStatus() {
        context = getApplicationContext();
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

    }


    public void GpsDirect() {


        AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
        builder.setTitle("Need location service ");  // GPS not found
        builder.setMessage("Laundry would like to use your location .Please Enable location Service"); // Want to enable?
        builder.setPositiveButton("GO TO SETTINGS", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });
        builder.setNegativeButton("LATER", null);
        builder.create().show();
        return;
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();

        Marker(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()));

        return false;
    }
}