package com.example.sunrinchungwon.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sunrinchungwon.Activities.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.recycler_item;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Example3Fragment extends Fragment {
    EditText title,introduction, mainSubject, conclusion;
    Button submitBtn;
    Spinner mSpinner;
    MainActivity activity;
    recycler_item item;
    String fillter;
    String title_str,intro_str,mainsub_str,conclu_str;


    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private static FirebaseDatabase database;
    private FirebaseFirestore firebaseFirestore;


    public Example3Fragment() {
        firebaseFirestore=FirebaseFirestore.getInstance();
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_example3, container, false);
        activity=(MainActivity)getActivity();
        title=v.findViewById(R.id.frag3_title);
        introduction=v.findViewById(R.id.frag3_introduction);
        mainSubject=v.findViewById(R.id.frag3_mainSubject);
        conclusion=v.findViewById(R.id.frag3_conclusion);
        submitBtn=v.findViewById(R.id.frag3_submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_str=title.getText().toString();
                intro_str=introduction.getText().toString();
                mainsub_str=mainSubject.getText().toString();
                conclu_str=conclusion.getText().toString();
                if(!title.equals("")&&!intro_str.equals("")&&!mainsub_str.equals("")&&!conclu_str.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("제출");
                    builder.setMessage("본문을 정말 제출하시겠습니까?");
                    builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            CollectionReference collectionReference = firebaseFirestore.collection("post");
                            recycler_item tofireItem=new recycler_item(title_str,getCurrentTime(),getString(R.string.not_answered),intro_str,mainsub_str,conclu_str,fillter);
                            collectionReference.add(tofireItem);
                            //파베에 값올리기
                        }
                    });
                    builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        activity=(MainActivity)getActivity();
        mSpinner=v.findViewById(R.id.frag3_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillter=(String)parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
