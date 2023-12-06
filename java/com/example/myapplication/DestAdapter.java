package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class DestAdapter extends RecyclerView.Adapter<DestAdapter.DestViewHolder> {

    Context context;
    List<DestData> destDataList;

    public DestAdapter(Context context, List<DestData> destDataList) {
        this.context = context;
        this.destDataList = destDataList;
    }

    @NonNull
    @Override
    public DestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.dest_row_item,parent,false);
        return new DestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestViewHolder holder, int position) {

        holder.placeName.setText(destDataList.get(position).getPlaceName());
        holder.countryName.setText(destDataList.get(position).getCountryName());
        holder.placeImage.setImageResource(destDataList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() { return destDataList.size(); }

    public static final class DestViewHolder extends RecyclerView.ViewHolder {

        ImageView placeImage;
        TextView placeName, countryName;

        public DestViewHolder(@NonNull View itemView) {
            super(itemView);

            placeImage = itemView.findViewById(R.id.dest_image);
            placeName = itemView.findViewById(R.id.place_name);
            countryName = itemView.findViewById(R.id.country_name);

        }
    }
}

