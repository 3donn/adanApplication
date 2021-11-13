package com.example.adansapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
        // Login
    EditText Emailloginmain ,passloginmain ;
    Button btnloginmain;
    FirebaseAuth mAuth;
    EditText Emailsignupmain , passsignupmain ;
    Button btnsignupmain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Emailloginmain = (EditText) findViewById(R.id.Emailloginmain) ;
        passloginmain = (EditText) findViewById(R.id.passloginmain) ;
        btnloginmain = (Button) findViewById(R.id.btnloginmain) ;
        mAuth = FirebaseAuth.getInstance();
        Emailsignupmain = (EditText) findViewById(R.id.Emailloginmain) ;
        passsignupmain = (EditText) findViewById(R.id.passloginmain) ;
        btnsignupmain = (Button) findViewById(R.id.btnloginmain) ;
    }
         //login
    public void login (View view) {

        String username = Emailloginmain.getText().toString() ;
        String password = passloginmain.getText().toString() ;

         // login validation
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                        } else {

                            Toast.makeText(getApplicationContext(), "your user name opr password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

        //signup
    public void signup (View view) {
        String username = Emailsignupmain.getText().toString() ;
        String password = passsignupmain.getText().toString() ;

        // signup validation
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Intent w = new Intent(getApplicationContext(), FeedActivity2.class);
                        } else {
                            Toast.makeText(getApplicationContext(), "your user name opr password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}