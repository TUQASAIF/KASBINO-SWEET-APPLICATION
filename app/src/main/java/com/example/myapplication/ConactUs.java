package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConactUs extends AppCompatActivity {
    Button mpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conact_us);

        mpa= findViewById(R.id.Bckk);

        mpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConactUs.this, "BACK TO HOME PAGE", Toast.LENGTH_LONG).show();
                Intent oo = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(oo);
            }
        });

        // Initialize TextViews
        TextView textViewContact = findViewById(R.id.tvC);
        TextView textViewWhatsapp = findViewById(R.id.tVw);
        TextView textViewPhone = findViewById(R.id.tvP);
        TextView textViewInstagram = findViewById(R.id.tvP);


        // Set contact information
        textViewContact.setText("     CONTACT US");
        textViewWhatsapp.setText("    WHATSAPP: +968 94015977");
        textViewPhone.setText("       PHONE NUMBER: +968 94015977");
        textViewInstagram.setText("   INSTAGRAM: KASBINO.7");
    }
}
