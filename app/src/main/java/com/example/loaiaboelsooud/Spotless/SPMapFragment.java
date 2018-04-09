package com.example.loaiaboelsooud.Spotless;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SPMapFragment extends Fragment implements OnMapReadyCallback {
    private static final float DEFAULT_ZOOM = 15f;
    private GoogleMap mMap;
//TODO: Add route between 2 locations
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_spmap, container, false);
        super.onCreate(savedInstanceState);
        initMap();
        return rootView;
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.spmap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = new LatLng(-33.852, 151.211);
        LatLng sydney2 = new LatLng(-33.802, 151.211);
        Marker(sydney);
        Marker(sydney2);
    }

    public SPMapFragment() {
        super();
    }


    private void Marker(LatLng currentLocation) {
        mMap.addMarker(new MarkerOptions().position(currentLocation).draggable(true));
        moveCamera(currentLocation, DEFAULT_ZOOM);

    }

    private void moveCamera(LatLng latLng, float zoom) {

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }
}
