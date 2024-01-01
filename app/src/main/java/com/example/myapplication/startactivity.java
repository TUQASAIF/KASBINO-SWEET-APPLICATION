package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class startactivity extends AppCompatActivity {
    dbHelper MyDB;
    EditText name, sweetc, sweetnm, phonen;
    Button cal, sbmit, delete, V, U, clear , menupage , hop,rd;
    TextView totalAmount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);
        name = findViewById(R.id.nm);
        sweetnm = findViewById(R.id.sn);
        sweetc = findViewById(R.id.sc);
        phonen = findViewById(R.id.pn);
        cal = findViewById(R.id.BPrice);
        sbmit = findViewById(R.id.Bsbmit);
        U = findViewById(R.id.BU);
        clear = findViewById(R.id.BC);
        delete = findViewById(R.id.Bdelete);
        V = findViewById(R.id.BV);
        hop=findViewById(R.id.Bbackk);
        rd=findViewById(R.id.Bred);
        menupage=findViewById(R.id.Bmenu);
        totalAmount = findViewById(R.id.sp);

        MyDB = new dbHelper(this);

        Dadd();
        Dupdate();
        Ddelete();
        Dview();


        rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details="READ SUCCESSFUL";
                name.setText(details);
                sweetc.setText(details);
                sweetnm.setText(details);
                phonen.setText(details);
            }
        });

               hop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(startactivity.this, "GO TO HOME PAGE", Toast.LENGTH_LONG).show();
                Intent po = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(po);
            }
        });

        menupage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(startactivity.this, "GO TO MENU PAGE", Toast.LENGTH_LONG).show();
                Intent ss = new Intent(getApplicationContext(), sweetmenu.class);
                startActivity(ss);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                sweetc.setText("");
                sweetnm.setText("");
                phonen.setText("");
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || sweetc.getText().toString().isEmpty() || sweetnm.getText().toString().isEmpty() || phonen.getText().toString().isEmpty()) {
                    Toast.makeText(startactivity.this, "PLEASE FILED REQUIRED", Toast.LENGTH_SHORT).show();
                } else {
                    double sp = 1.500;
                    double swtn =
                            Double.parseDouble(sweetnm.getText().toString());
                    double to = (sp * swtn);
                    totalAmount.setText(Double.toString(sp));
                    totalAmount.setText("TOTAL AMOUNT=" + to + "OMANI RIYAL");
                }
            }
        });
    }


    public void Dadd() {
        sbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insert = MyDB.insertData(name.getText().toString(), sweetnm.getText().toString(), sweetc.getText().toString(), phonen.getText().toString());
                if (insert == true)
                    Toast.makeText(startactivity.this, "SUCCESSFUL INSERTED DETAILS", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(startactivity.this, "FAILED INSERTED DETAILS", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Dupdate(){
        U.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean updated=MyDB.updateData(name.getText().toString(),sweetnm.getText().toString(), sweetc.getText().toString(),phonen.getText().toString());
                if(updated==true)
                    Toast.makeText(startactivity.this,"SUCCESSFUL UPDATED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(startactivity.this, "FAILED UPDATED",Toast.LENGTH_LONG).show();
            }
        });
    }




    public void Ddelete() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer let = MyDB.deleteData(phonen.getText().toString());
                if (let > 0)
                    Toast.makeText(startactivity.this, "INFORMATION IS DELETED", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(startactivity.this, "INFORMATION NOT DELETED", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Dview() {
        V.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor u = MyDB.getAllData();
                if (u.getCount() == 0) {
                    Toast.makeText(startactivity.this, "INFORMATION NOT AVAILABLE", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder qa = new StringBuilder();
                while (u.moveToNext()) {
                    qa.append("NAME:").append(u.getString(0)).append("\n");
                    qa.append("SWEET NUMBER:").append(u.getString(1)).append("\n");
                    qa.append("SWEET CODE:").append(u.getString(2)).append("\n");
                    qa.append("PHONE NUMBER:").append(u.getString(3)).append("\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(startactivity.this);
                builder.setCancelable(true);
                builder.setTitle("SWEET ORDER DETAILS");
                builder.setMessage(qa.toString());
                builder.show();
            }
        });
    }

}
