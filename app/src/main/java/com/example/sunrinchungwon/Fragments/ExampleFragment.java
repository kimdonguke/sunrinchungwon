package com.example.sunrinchungwon.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sunrinchungwon.Adapters.RecyclerViewAdapter;
import com.example.sunrinchungwon.Activities.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.recycler_item;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class ExampleFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Spinner mSpinner;
    MainActivity mainActivity;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<recycler_item> recycler_item;

    String fillter_string;
    String title;
    String date;
    String isResponed;
    private Context context = getContext();


    public ExampleFragment() {

    }


    public static ExampleFragment newInstance(String param1, String param2) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_example, container, false);
        mainActivity = (MainActivity) getActivity();
        recyclerView = v.findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.addItemDecoration(new DividerItemDecoration(mainActivity, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);
       recycler_item = new ArrayList<>();
        recycler_item.add(new recycler_item("김덕배", "010-1234-5678", "기모링!", "", "", ""));
        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, recycler_item);
        recyclerView.setAdapter(recyclerViewAdapter);
        swipeRefreshLayout = v.findViewById(R.id.frag1_swipelayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //새로고침 코드
                recycler_item.add(new recycler_item("MainTitle", getCurrentTime(), "답변 안 됨", "", "", ""));
                recyclerViewAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        mSpinner = v.findViewById(R.id.frag1_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String string = "이 선택되었습니다.";

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mainActivity, (String) parent.getItemAtPosition(position) + string, Toast.LENGTH_SHORT).show();
                fillter_string = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }
    public void removeItem(String fillter_string){
        for(int i=0;i<recycler_item.size();i++){
            switch (fillter_string){
                case "전체":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
                case "1호관":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
                case "2호관":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
                case "3호관":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
                case "4호관":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
                case "체육관":
//                        Toast.makeText(mainActivity,(String)parent.getItemAtPosition(position)+"was selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
    public String getCurrentTime(){
        Date currentTiem= Calendar.getInstance().getTime();
        SimpleDateFormat a =new SimpleDateFormat("MM-dd HH:mm");
        return a.format(currentTiem);
    }
}
