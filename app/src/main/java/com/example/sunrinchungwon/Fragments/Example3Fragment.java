package com.example.sunrinchungwon.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sunrinchungwon.MainActivity;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.recycler_item;

public class Example3Fragment extends Fragment {
    EditText title,introduction, mainSubject, conclusion;
    Button submitBtn;
    Spinner mSpinner;
    MainActivity activity;
    recycler_item item;
    public Example3Fragment() {
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
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("제출");
                builder.setMessage("본문을 정말 제출하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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
        });
        activity=(MainActivity)getActivity();
        mSpinner=v.findViewById(R.id.frag3_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch ((String)parent.getItemAtPosition(position)){
                    case "전체":

                        break;
                    case "1호관":

                        break;
                    case "2호관":

                        break;
                    case "3호관":

                        break;
                    case "4호관":

                        break;
                    case "체육관":

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }

}
