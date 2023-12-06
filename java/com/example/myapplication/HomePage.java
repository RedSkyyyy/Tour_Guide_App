package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityHomepageBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView destRecycler, hotelRecycler;
    DestAdapter destAdapter;
    HotelAdapter hotelAdapter;
    ActivityHomepageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                replaceActivity(HomePage.class);
            } else if (itemId == R.id.favorite) {
                replaceActivity(Favorite.class);
            } else if (itemId == R.id.profile) {
                replaceActivity(Profile.class);
            }

            return true;
        });

        List<DestData> destDataList = new ArrayList<>();
        destDataList.add(new DestData("Mount Bromo", "Indonesia", R.drawable.destimage1));
        destDataList.add(new DestData("Colloseum", "Rome", R.drawable.destimage2));
        destDataList.add(new DestData("Angkor Wat", "Thailand", R.drawable.destimage3));
        destDataList.add(new DestData("Bora-Bora", "France", R.drawable.destimage4));

        setDestRecycler(destDataList);

        List<HotelData> hotelDataList = new ArrayList<>();
        hotelDataList.add(new HotelData("Nayara Tented Camp", "Costa Rica", R.drawable.hotelimage1));
        hotelDataList.add(new HotelData("Grace Hotel Santorini", "Greece", R.drawable.hotelimage2));
        hotelDataList.add(new HotelData("Atlantis The Royal", "UEA", R.drawable.hotelimage3));
        hotelDataList.add(new HotelData("The Anam", "Vietnam", R.drawable.hotelimage4));

        setHotelRecycler(hotelDataList);
    }

    private void setDestRecycler(List<DestData> destDataList) {
        destRecycler = findViewById(R.id.dest_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        destRecycler.setLayoutManager(layoutManager);
        destAdapter = new DestAdapter(this,destDataList);
        destRecycler.setAdapter(destAdapter);
    }

    private void setHotelRecycler(List<HotelData> hotelDataList) {
        hotelRecycler = findViewById(R.id.hotel_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        hotelRecycler.setLayoutManager(layoutManager);
        hotelAdapter = new HotelAdapter(this, hotelDataList);
        hotelRecycler.setAdapter(hotelAdapter);
    }

    private void replaceActivity(Class<? extends AppCompatActivity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

}
