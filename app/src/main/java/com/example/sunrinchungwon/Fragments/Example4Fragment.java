package com.example.sunrinchungwon.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sunrinchungwon.Adapters.NotificationAdapter;
import com.example.sunrinchungwon.Adapters.RecyclerViewAdapter;
import com.example.sunrinchungwon.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.notification_item;

import java.util.ArrayList;


public class Example4Fragment extends Fragment {

    // TODO: Rename and change types of parameters
    private RecyclerView recyclerView;
    private NotificationAdapter notificationAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<notification_item> items;
    MainActivity mainActivity;

    public Example4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_example4, container, false);
        mainActivity=(MainActivity)getActivity();
        recyclerView=v.findViewById(R.id.frag4_recyclerview);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.addItemDecoration( new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));
        items=new ArrayList<>();
        items.add(new notification_item("노티_타이틀","노티_날짜"));
        recyclerView.setLayoutManager(linearLayoutManager);
        notificationAdapter=new NotificationAdapter(items,mainActivity);
        recyclerView.setAdapter(notificationAdapter);

        // Inflate the layout for this fragment
        return v;
    }

}
