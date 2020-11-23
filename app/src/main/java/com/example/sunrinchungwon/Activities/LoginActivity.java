package com.example.sunrinchungwon.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sunrinchungwon.R;

public class LoginActivity extends AppCompatActivity {
    Button toMainActivity_btn, toSignUpActivity_btn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toMainActivity_btn=findViewById(R.id.loginActivity_idBtn);
        toSignUpActivity_btn=findViewById(R.id.loginActivity_SignUpBtn);

        toMainActivity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getBaseContext(),MainActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        toSignUpActivity_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
        init();
    }
    void init(){

    }
}
