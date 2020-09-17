package com.example.vehiclebreakdownsystem;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NotificationCompat;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class problems extends AppCompatActivity {
    private EditText no,msg;
    private Button btnSendSms;
    private Button call;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);
        no=(EditText)findViewById(R.id.editText1);
        msg=(EditText)findViewById(R.id.editText2);
        btnSendSms=(Button)findViewById(R.id.button1);

        call=(Button)findViewById(R.id.buttoncall);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent callIntent=new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+1-555-521-5554"));
                if(ActivityCompat.checkSelfPermission(problems.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                startActivity(callIntent); }
        });
        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSms();

            }
        });

    }

    protected void sendSms(){
        String number=no.getText().toString();
        String message=msg.getText().toString();
        SmsManager manager=SmsManager.getDefault();
        Intent intent=new Intent(getApplicationContext(),problems.class);
        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        manager.sendTextMessage("+1-555-521-5554",null,"message",null,pi);
        Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_LONG).show();

    }

}

