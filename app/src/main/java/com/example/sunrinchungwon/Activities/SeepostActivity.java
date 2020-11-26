package com.example.sunrinchungwon.Activities;

import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunrinchungwon.Adapters.Seepost_commentAdapter;
import com.example.sunrinchungwon.R;
import com.example.sunrinchungwon.items.Code;
import com.example.sunrinchungwon.items.seepost_item;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SeepostActivity extends AppCompatActivity {
    private Intent getintent;
    String title,date,isResponed,introduction,mainSubject,conclusion;
    TextView tv_title,tv_date,tv_introduction,tv_mainSubject,tv_conclusion;
    Button btn_agree, btn_proscon;
    Dialog dialog;
    String holy_proscon_String;
    private ArrayList<seepost_item> dataList;
    Seepost_commentAdapter adapter;
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

        final RecyclerView recyclerView = findViewById(R.id.seepost_recyclerview);
        dataList=new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        adapter=new Seepost_commentAdapter(dataList,this);
        recyclerView.setAdapter(adapter);  // Adapter 등록

        btn_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //agree 버튼 온클릭 리스너
                //서버에게 리사이클러뷰 올리는 쓰레드 생성
                dataList.add(new seepost_item("유저아이디",getCurrentTime(), Code.ViewType.AGREE_CONTENT));
                adapter.notifyDataSetChanged();
            }
        });
        btn_proscon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=new Dialog(SeepostActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.seepost_dialogue);

                Button okayBtn=(Button)dialog.findViewById(R.id.seepost_dia_okayBtn);
                final EditText titleEdit=(EditText) dialog.findViewById(R.id.seepost_dia_title);
                final EditText contentsEdit=(EditText)dialog.findViewById(R.id.seepost_dia_content);
                okayBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(titleEdit.getText().toString().equals("")||contentsEdit.getText().toString().equals("")){
                            Toast.makeText(SeepostActivity.this, "내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            dataList.add(new seepost_item(titleEdit.getText().toString(),contentsEdit.getText().toString(),Code.ViewType.PROSCON_CONTENT));
                            adapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });
    }
    public String getCurrentTime(){
        Date currentTiem= Calendar.getInstance().getTime();
        SimpleDateFormat a =new SimpleDateFormat("MM-dd HH:mm");
        return a.format(currentTiem);
    }
}
