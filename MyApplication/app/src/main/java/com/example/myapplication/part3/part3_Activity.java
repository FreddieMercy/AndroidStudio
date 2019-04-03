package com.example.myapplication.part3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.R;

public class part3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        ListView list = (ListView) findViewById(R.id.part3_ListView);
        list.setAdapter(new itemAdapter(this, getResources().getStringArray(R.array.items),getResources().getStringArray(R.array.descriptions),getResources().getStringArray(R.array.prices)));
    }



}
