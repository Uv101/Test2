package com.example.dell_1.test.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell_1.test.R;
import com.example.dell_1.test.model.ServiceProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {


    private List<ServiceProvider> serviceProviderList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_tilte;
        public TextView tv_distance;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            tv_tilte = (TextView) view.findViewById(R.id.tv_tilte);
            tv_distance = (TextView) view.findViewById(R.id.tv_distance);
            img = (ImageView) view.findViewById(R.id.img);
        }
    }


    public Adapter(List<ServiceProvider> serviceProviderList, Activity activity) {
        this.serviceProviderList = serviceProviderList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ServiceProvider serviceProvider = serviceProviderList.get(position);
        holder.tv_tilte.setText(serviceProvider.getFirst_name());
        holder.tv_distance.setText(serviceProvider.getDistance());
        Picasso.with(activity).load(serviceProvider.getProfile_pic()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return serviceProviderList.size();
    }


}
