package com.example.sunrinchungwon.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.Activities.SeepostActivity;
import com.example.sunrinchungwon.items.notification_item;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    ArrayList<notification_item> items;
    Activity activity;
    Intent intent;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.notification_item, viewGroup, false);
        NotificationAdapter.ViewHolder viewHolder=new NotificationAdapter.ViewHolder(view);
        return viewHolder;
    }

    public NotificationAdapter(ArrayList<notification_item> items, Activity activity) {
        this.activity=activity;
        this.items=items;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        notification_item item=items.get(i);
        viewHolder.notification_title.setText(item.getNotificationTitle());
        viewHolder.notification_date.setText(item.getNotificationDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView notification_title;
        TextView notification_date;
        ImageButton notification_imageButton;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            notification_title=itemView.findViewById(R.id.notification_title);
            notification_date=itemView.findViewById(R.id.notification_date);
            notification_imageButton=itemView.findViewById(R.id.notification_button);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        intent=new Intent(activity,SeepostActivity.class);
                        activity.startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(activity, ""+e, Toast.LENGTH_SHORT).show();
                    }
                }
            });
            notification_imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "imageButton_Clicked", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}