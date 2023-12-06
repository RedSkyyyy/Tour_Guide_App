package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    Context context;
    List<HotelData> hotelDataList;

    public HotelAdapter(Context context, List<HotelData> hotelDataList) {
        this.context = context;
        this.hotelDataList = hotelDataList;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hotel_row_item,parent,false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {

        holder.placeName.setText(hotelDataList.get(position).getPlaceName());
        holder.countryName.setText(hotelDataList.get(position).getCountryName());
        holder.placeImage.setImageResource(hotelDataList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    public static final class HotelViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, countryName;

        public HotelViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.hotel_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);

        }
    }
}
