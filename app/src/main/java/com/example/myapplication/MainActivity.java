package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button conus, log , order , inl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conus = findViewById(R.id.Bcontact);
        log = findViewById(R.id.Blog);
        order = findViewById(R.id.orderb);
        inl = findViewById(R.id.Bin);


        inl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "GO TO LOGIN PAGE", Toast.LENGTH_LONG).show();
                Intent ts = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(ts);
            }
        });

        conus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "GO TO CONTACT US PAGE", Toast.LENGTH_LONG).show();
                Intent it = new Intent(MainActivity.this,ConactUs.class);
                startActivity(it);
            }
        });


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nn = new Intent(MainActivity.this,startactivity.class);
                startActivity(nn);
                finish();
            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
