package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText naur,wdps;
    Button ilog,ireg,pgc;
    private dbHelper1 hdb;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hdb=new dbHelper1(this);

        naur=(EditText) findViewById(R.id.usen);
        wdps=(EditText) findViewById(R.id.wordp);
        ilog=(Button) findViewById(R.id.inlog);
        ireg=(Button) findViewById(R.id.inreg);
        pgc=(Button) findViewById(R.id.cakk);



        ilog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un=naur.getText().toString();
                String ps=wdps.getText().toString();

                if(hdb.validateUser(un,ps))
                {
                    Toast.makeText(getApplicationContext(),"SUCESSFULLY LOGIN",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"FAILED LOGIN",Toast.LENGTH_LONG).show();
                }
            }
        });


        ireg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity.this, registrationActivity.class);
                startActivity(intent);
            }
        });


        pgc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(loginActivity.this, "BACK TO HOME PAGE", Toast.LENGTH_LONG).show();
                Intent oo = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(oo);
            }
        });
    }
}
