package com.example.sunrinchungwon.Activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sunrinchungwon.R;

public class SignUpActivity extends AppCompatActivity {

    Button signIn_btn;
    EditText user_name,user_id,user_password;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signIn_btn=findViewById(R.id.signin_goBtn);
        user_id=findViewById(R.id.signin_userId);
        user_name=findViewById(R.id.signin_name);
        user_password=findViewById(R.id.signin_passworld);
        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getBaseContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
