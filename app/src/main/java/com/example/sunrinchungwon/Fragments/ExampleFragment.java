package com.example.sunrinchungwon.Fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sunrinchungwon.Adapters.RecyclerViewAdapter;
import com.example.sunrinchungwon.Activities.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.Code;
import com.example.sunrinchungwon.items.recycler_item;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class ExampleFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Spinner mSpinner;
    MainActivity mainActivity;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<recycler_item> recycler_item;
    ArrayList<recycler_item> final_recycler_item;

    String fillter_string;
    String title;
    String date;
    String isResponed;
    private Context context = getContext();


    public ExampleFragment() {

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

        recycler_item = new ArrayList<>();
        final_recycler_item=new ArrayList<>();

        linearLayoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.addItemDecoration(new DividerItemDecoration(mainActivity, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recycler_item.add(new recycler_item("Fuckyou", getCurrentTime(), "기모링!", "", "", "",Code.TagClass.EVERYTHING));
        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, recycler_item);
        recyclerView.setAdapter(recyclerViewAdapter);

        final_recycler_item=recycler_item;

        swipeRefreshLayout = v.findViewById(R.id.frag1_swipelayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //새로고침 코드
                Log.d("onRefresh","start");
                recycler_item.add(new recycler_item("MainTitle", getCurrentTime(), "답변 안 됨", "", "", "", Code.TagClass.GYM));
                recycler_item.add(new recycler_item("MainTitle", getCurrentTime(), "답변 안 됨", "", "", "",Code.TagClass.EVERYTHING));
                recycler_item.add(new recycler_item("MainTitle", getCurrentTime(), "답변 안 됨", "", "", "",Code.TagClass.HOGWAN3));
                recyclerViewAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
                Log.d("onRefresh","end");
            }
        });
        mSpinner = v.findViewById(R.id.frag1_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("MainActivity",(String) parent.getItemAtPosition(position));
                fillter_string = (String) parent.getItemAtPosition(position);
                makeFillterItems(fillter_string);
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(mainActivity, "Spinner-onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    public void makeFillterItems(String fillter_string){
        Log.e("makeFillterItems",""+recycler_item.size());
        ArrayList<recycler_item> arrayList=new ArrayList<>();
        if(!(fillter_string.equals("전체"))){
            for(int i=0; i<recycler_item.size(); i++){
                if(recycler_item.get(i).getTag().equals(fillter_string)){
                    Log.e("makeFillterItems",""+i);
                    //바로 리무브 하면 위에 조건문에서 사이즈가 줄어버림.
                    arrayList.add(recycler_item.get(i));

                }
            }
            recycler_item.clear();
            for(int i=0;i<arrayList.size();i++){
                recycler_item.add(arrayList.get(i));
            }
        }
        else{

        }
    }
    public String getCurrentTime(){
        Date currentTiem= Calendar.getInstance().getTime();
        SimpleDateFormat a =new SimpleDateFormat("MM-dd HH:mm");
        return a.format(currentTiem);
    }
}