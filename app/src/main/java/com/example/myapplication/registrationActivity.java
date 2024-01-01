package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class registrationActivity extends AppCompatActivity {
    EditText n,w;
    Button account;
    private dbHelper1 dhb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        dhb=new dbHelper1(this);

        n=(EditText) findViewById(R.id.nuser);
        w=(EditText) findViewById(R.id.wpas);
        account=(Button) findViewById(R.id.ca);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=n.getText().toString();
                String pa=w.getText().toString();

                dhb.addUser(user,pa);
                Toast.makeText(getApplicationContext(),"SUCCESSFULLY REGISTER ",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(registrationActivity.this,loginActivity.class);
                startActivity(intent);

            }
        });

    }
}
