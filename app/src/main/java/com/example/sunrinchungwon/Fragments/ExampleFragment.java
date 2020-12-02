package com.example.sunrinchungwon.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import com.example.sunrinchungwon.items.recycler_item;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ExampleFragment extends Fragment{

    private static final int LIMIT = 50;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private Spinner mSpinner;

    MainActivity mainActivity;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<recycler_item> recycler_items;
    ArrayList<recycler_item> final_recycler_item;

    String fillter_string;
    String title;
    String date;
    String isResponed;
    private Context context = getContext();

    private FirebaseAuth mAuth;
    //현재 로그인 된 유저 정보를 담을 변수
    private FirebaseUser currentUser;
    private static FirebaseFirestore firebaseFirestore;

    public ExampleFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        initFirestore();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_example, container, false);
        mainActivity = (MainActivity) getActivity();
        recyclerView = v.findViewById(R.id.recyclerView);

        recycler_items = new ArrayList<>();
        final_recycler_item=new ArrayList<>();

        initRecyclerView();
        for(int i = 0; i<recycler_items.size();i++){
            Log.e("in formoon",recycler_items.get(i).getIntroduction());
        }

        swipeRefreshLayout = v.findViewById(R.id.frag1_swipelayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //새로고침 코드
                recycler_items.clear();
                firebaseFirestore.collection("post").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Timestamp timestamp = document.getTimestamp("date");
                                recycler_items.add(new recycler_item("" + document.get("title"), timestamp, "" + document.get("isResponed"), "" + document.get("introduction"), "" + document.get("mainSubject"), "" + document.get("conclusion"), "" + document.get("tag")));
                                Log.d("frag",""+document.get("tag"));
                                recyclerViewAdapter.notifyDataSetChanged();
                            }
                        }
                        else {
                            Log.d("frag", "Error getting documents: ", task.getException());
                        }
                    }
                });
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
                recycler_items.clear();
                firebaseFirestore.collection("post").orderBy("date", Query.Direction.ASCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("frag", document.getId() + " => " + document.get("title"));
                                try {
                                    if(document.get("tag")==fillter_string) {
                                        Timestamp timestamp = document.getTimestamp("date");
                                        recycler_items.add(new recycler_item("" + document.get("title"), timestamp, "" + document.get("isResponed"), "" + document.get("introduction"), "" + document.get("mainSubject"), "" + document.get("conclusion"), "" + document.get("tag")));
                                        Log.e("frag", "" + document.get("tag"));
                                        recyclerViewAdapter.notifyDataSetChanged();
                                    }
                                }
                                catch (Exception e){
                                    Toast.makeText(mainActivity, "loading failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else {
                            Log.d("frag", "Error getting documents: ", task.getException());
                        }
                    }
                });
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(mainActivity, "Spinner-onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    private void initFirestore() {
        firebaseFirestore = FirebaseFirestore.getInstance();
    }
    private void initRecyclerView() {
        firebaseFirestore.collection("post").orderBy("date", Query.Direction.ASCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("frag", document.getId() + " => " + document.get("title"));
                        try {
                            Timestamp timestamp = document.getTimestamp("date");
                            recycler_items.add(new recycler_item("" + document.get("title"), timestamp, "" + document.get("isResponed"), "" + document.get("introduction"), "" + document.get("mainSubject"), "" + document.get("conclusion"), "" + document.get("tag")));
                            Log.e("frag get title", "" + document.get("title"));
                            Log.e("frag get tag", "" + document.get("tag"));
                            Log.e("frag get intro",""+document.get("introduction"));
                            Log.e("in recycleritems",recycler_items.get(recycler_items.size()-1).getIntroduction());
                        }
                        catch (Exception e){
                            Toast.makeText(mainActivity, "loading failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                    Log.d("frag", "Error getting documents: ", task.getException());
                }
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        recyclerView.addItemDecoration(new DividerItemDecoration(mainActivity, linearLayoutManager.getOrientation()));
        recyclerView.setLayoutManager(linearLayoutManager);
        Log.d("frag1:",""+recycler_items.size());

        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity, recycler_items);

        // callback 함수 구현하라는데 맞는지 모르겠네
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}