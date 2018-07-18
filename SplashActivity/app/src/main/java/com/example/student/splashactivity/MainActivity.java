package com.example.student.splashactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        Button start = findViewById(R.id.IDbuton1);
        start.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent = new Intent("com.example.student.broadcast.START_NOTIFICARI");
                sendBroadcast(intent);

            }

        });


        Button stop = findViewById(R.id.IDbuton2);
        stop.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                Intent intent = new Intent("com.example.student.broadcast.STOP_NOTIFICARI");
                sendBroadcast(intent);
            }

        });

    }
}
