package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class sweetmenu extends AppCompatActivity {

    ImageView swee;
    Button bkk;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweetmenu);

        swee = findViewById(R.id.swe);
        bkk = findViewById(R.id.bk);


        bkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(sweetmenu.this, "BACK TO ORDER PAGE", Toast.LENGTH_LONG).show();
                Intent th = new Intent(getApplicationContext(), startactivity.class);
                startActivity(th);

            }
        });
    }
}
