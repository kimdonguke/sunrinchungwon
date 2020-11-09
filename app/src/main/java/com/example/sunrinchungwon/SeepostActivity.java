package com.example.sunrinchungwon;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SeepostActivity extends AppCompatActivity {
    private Intent getintent;
    String title,date,isResponed,introduction,mainSubject,conclusion;
    TextView tv_title,tv_date,tv_introduction,tv_mainSubject,tv_conclusion;
    Button btn_agree, btn_proscon;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seepost);
        getintent=getIntent();
        title=getintent.getStringExtra("title");
        date=getintent.getStringExtra("date");
        isResponed=getintent.getStringExtra("isResponed");
        introduction=getintent.getStringExtra("introduction");
        mainSubject=getintent.getStringExtra("mainSubject");
        conclusion=getintent.getStringExtra("conclusion");
        tv_title=(TextView) findViewById(R.id.seepost_title);
        tv_date=(TextView) findViewById(R.id.seepost_date);
        tv_introduction=(TextView) findViewById(R.id.seepost_introduction);
        tv_mainSubject=(TextView) findViewById(R.id.seepost_mainSubject);
        tv_conclusion=(TextView) findViewById(R.id.seepost_conclusion);
        tv_title.setText(title);
        tv_date.setText(date);
        tv_introduction.setText(introduction);
        tv_mainSubject.setText(mainSubject);
        tv_conclusion.setText(conclusion);
        btn_agree=findViewById(R.id.seepost_agree);
        btn_proscon=findViewById(R.id.seepost_dialogueBtn);
        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //agree 버튼 온클릭 리스너
            }
        });
        btn_proscon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(SeepostActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.seepost_dialogue);
                dialog.show();
                Button okayBtn=(Button)dialog.findViewById(R.id.seepost_dia_okayBtn);
                EditText prosEdit=(EditText) dialog.findViewById(R.id.seepost_dia_prosEdit);
                okayBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
    }
}
