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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


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

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private static FirebaseDatabase database;
    private static FirebaseFirestore firebaseFirestore;

    public ExampleFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        Init();
    }

    private void Init() {
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
        recycler_item.add(new recycler_item("학교가 너무 낡았어요", getCurrentTime(), "답변 안 됨", "학교가 너무너무 낡았어요. 그래서 고쳐야 할 것 같아요", "학교가 기울어져서 어쩌구 저쩌구", "꼭좀 고쳐주세요",Code.TagClass.EVERYTHING));
        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, recycler_item);
        recyclerView.setAdapter(recyclerViewAdapter);

        final_recycler_item=recycler_item;

        swipeRefreshLayout = v.findViewById(R.id.frag1_swipelayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //새로고침 코드
                Log.d("onRefresh","start");
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
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(mainActivity, "Spinner-onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
    public String getCurrentTime(){
        Date currentTiem= Calendar.getInstance().getTime();
        SimpleDateFormat a =new SimpleDateFormat("MM-dd HH:mm");
        return a.format(currentTiem);
    }
}