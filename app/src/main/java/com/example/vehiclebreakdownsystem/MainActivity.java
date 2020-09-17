package com.example.vehiclebreakdownsystem;


import android.app.Dialog;

import android.content.Intent;
import android.os.Build;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    Database db;
    EditText e1, e2, e3, e4, e5;
    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new Database(this);


        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.phone);
        e3 = (EditText) findViewById(R.id.email);
        e4 = (EditText) findViewById(R.id.pass);
        e5 = (EditText) findViewById(R.id.cpass);
        b1 = (Button) findViewById(R.id.register);
        b2 = (Button) findViewById(R.id.login);
        b3 = (Button) findViewById(R.id.registerc);
        b4 = (Button) findViewById(R.id.loginc);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e4.getText().toString();
                if (s4.equals("") || s5.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "1 or more Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s4.equals(s5)) {
                        Boolean chkemail = db.chkemail(s3);
                        if (chkemail == true) {
                            Boolean insert = db.insert(s3, s4);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT);
                            }
                        }
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT);

                    }
                }


            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Loginc.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();
                String s5 = e4.getText().toString();
                if (s4.equals("") || s5.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "1 or more Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s4.equals(s5)) {
                        Boolean chkemail = db.chkemail(s3);
                        if (chkemail == true) {
                            Boolean insert = db.insert(s3, s4);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT);
                            }
                        }
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT);

                    }
                }
            }
        });

    }


}


