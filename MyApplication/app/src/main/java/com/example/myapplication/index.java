package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.part1.part1_Activity;
import com.example.myapplication.part2.part2_Activity_Main;
import com.example.myapplication.part3.part3_Activity;

public class index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //part1
        ((Button)findViewById(R.id.index_Part1Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), part1_Activity.class));
            }
        });

        //part2
        ((Button)findViewById(R.id.index_Part2Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent QAL = new Intent(getApplicationContext(), part2_Activity_Main.class);
                startActivity(QAL);
            }
        });

        //part3
        ((Button)findViewById(R.id.index_Part3Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), part3_Activity.class));
            }
        });
    }
}
