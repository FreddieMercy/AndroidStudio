package com.example.myapplication.part3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.R;

public class part3_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3);

        ListView list = (ListView) findViewById(R.id.part3_ListView);
        list.setAdapter(new itemAdapter(this, getResources().getStringArray(R.array.items),getResources().getStringArray(R.array.descriptions),getResources().getStringArray(R.array.prices)));
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent detail = new Intent(getApplicationContext(), part3_detail.class);
            detail.putExtra("Index", position);
            startActivity(detail);
        }
    });

    }



}
