package com.example.sunrinchungwon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class seepostActivity extends AppCompatActivity {
    private Intent getintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seepost);
        getintent=getIntent();
        // ???= getintent.getStringExtra(key(value:String));
    }
}
