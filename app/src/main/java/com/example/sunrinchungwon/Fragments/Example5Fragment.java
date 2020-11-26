package com.example.sunrinchungwon.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sunrinchungwon.R;


public class Example5Fragment extends Fragment implements View.OnClickListener{
    TextView sijak,chun1,chun2,chun3,chun4,jangmun,nandok,jungyee,baljun,itutnunde;

    public Example5Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example5, container, false);
        sijak=view.findViewById(R.id.frag5_newStart_tv);
        chun1=view.findViewById(R.id.frag5_chun1_tv);
        chun2=view.findViewById(R.id.frag5_chun2_tv);
        chun3=view.findViewById(R.id.frag5_chun3_tv);
        chun4=view.findViewById(R.id.frag5_chun4_tv);
        jangmun=view.findViewById(R.id.frag5_jangmun_tv);
        nandok=view.findViewById(R.id.frag5_nandok_tv);
        jungyee=view.findViewById(R.id.frag5_jungyee);
        baljun=view.findViewById(R.id.frag5_baljuun);
        itutnunde=view.findViewById(R.id.frag5_itutnunde);

        sijak.setOnClickListener(this);
        chun1.setOnClickListener(this);
        chun2.setOnClickListener(this);
        chun3.setOnClickListener(this);
        chun4.setOnClickListener(this);
        jangmun.setOnClickListener(this);
        nandok.setOnClickListener(this);
        jungyee.setOnClickListener(this);
        baljun.setOnClickListener(this);
        itutnunde.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.frag5_chun1_tv:
                makeDialog(chun1.getText().toString(),getString(R.string.chun1));
                break;
            case R.id.frag5_chun2_tv:
                makeDialog(chun2.getText().toString(),getString(R.string.chun2));
                break;
            case R.id.frag5_chun3_tv:
                makeDialog(chun3.getText().toString(),getString(R.string.chun3));
                break;
            case R.id.frag5_chun4_tv:
                makeDialog(chun4.getText().toString(),getString(R.string.chun4));
                break;
            case R.id.frag5_newStart_tv:
                makeDialog(sijak.getText().toString(),getString(R.string.sijak));
                break;
            case R.id.frag5_jangmun_tv:
                makeDialog(jangmun.getText().toString(),getString(R.string.jangmun));
                break;
            case R.id.frag5_nandok_tv:
                makeDialog(nandok.getText().toString(),getString(R.string.nandok));
                break;
            case R.id.frag5_jungyee:
                makeDialog(jungyee.getText().toString(),getString(R.string.jungyee));
                break;
            case R.id.frag5_baljuun:
                makeDialog(baljun.getText().toString(),getString(R.string.baljuun));
                break;
            case  R.id.frag5_itutnunde:
                makeDialog(itutnunde.getText().toString(),getString(R.string.itutnunde));
                break;
        }
        Log.e("frag5","view on clicked");
    }
    public void makeDialog(String title,String content){
        Log.e("frag5",title+content);
        AlertDialog.Builder builder =new AlertDialog.Builder(getContext());
        builder.setTitle(title);
        builder.setMessage(content);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create();
        builder.show();
    }
    //textView.setPaintFlags(textView.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG); 취소선 긋기
    //textView.setPaintFlags(0); 취소선 제거
}
