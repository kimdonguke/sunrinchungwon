package com.example.sunrinchungwon.Activities;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunrinchungwon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity {

    Button signIn_btn;
    EditText user_name,user_id,user_password;
    Intent intent;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);
        signIn_btn=findViewById(R.id.signin_goBtn);
        user_id=findViewById(R.id.signin_userId);
        user_name=findViewById(R.id.signin_name);
        user_password=findViewById(R.id.signin_passworld);

        mAuth = FirebaseAuth.getInstance();

        signIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, name, password;
                Log.e("SignUpActivity","sign_inBtn onClicked");
                email=user_id.getText().toString();
                name=user_name.getText().toString();
                password=user_password.getText().toString();
                joinStart(email,name,password);
            }
        });
    }
    public void joinStart(String email, final String name, String password){

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                final Context context=getApplicationContext();
                if(!task.isSuccessful()) {
                    try {
                        throw task.getException();
                    } catch(FirebaseAuthWeakPasswordException e) {
                        Toast.makeText(context,"비밀번호가 간단해요.." ,Toast.LENGTH_SHORT).show();
                    } catch(FirebaseAuthInvalidCredentialsException e) {
                        Toast.makeText(context,"email 형식에 맞지 않습니다." ,Toast.LENGTH_SHORT).show();
                    } catch(FirebaseAuthUserCollisionException e) {
                        Toast.makeText(context,"이미존재하는 email 입니다." ,Toast.LENGTH_SHORT).show();
                    } catch(Exception e) {
                        Toast.makeText(context,""+e ,Toast.LENGTH_SHORT).show();
                    }
                }else {
                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(name)
                            .build();

                    currentUser = mAuth.getCurrentUser();
                    currentUser.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(context, "가입, 성공적"+currentUser.getDisplayName(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    startActivity(new Intent(context, LoginActivity.class));
                    finish();
                }
            }
        });
    }
}
