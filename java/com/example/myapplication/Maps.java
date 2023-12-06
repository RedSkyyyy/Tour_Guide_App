package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import io.reactivex.rxjava3.annotations.NonNull;

public class Maps extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        map = findViewById(R.id.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap = googleMap;

        LatLng mapBromo = new LatLng(-7.942965,112.953186);
        this.gMap.addMarker(new MarkerOptions().position(mapBromo).title("Mount Bromo"));
        this.gMap.moveCamera(CameraUpdateFactory.newLatLng(mapBromo));
        this.gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        this.gMap.getUiSettings().setCompassEnabled(true);
        this.gMap.getUiSettings().isMyLocationButtonEnabled();
        this.gMap.getUiSettings().setZoomControlsEnabled(true);
        this.gMap.getUiSettings().setRotateGesturesEnabled(true);
        this.gMap.getUiSettings().setScrollGesturesEnabled(true);
        this.gMap.getUiSettings().setTiltGesturesEnabled(true);
    }
}