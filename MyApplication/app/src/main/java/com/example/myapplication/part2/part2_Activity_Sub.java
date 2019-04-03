package com.example.myapplication.part2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class part2_Activity_Sub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_sub);
        if(getIntent().hasExtra("inputText")){
            TextView tv = (TextView)findViewById(R.id.part2_act3_textView);
            tv.setText(getIntent().getExtras().get("inputText").toString());
        }
    }
}
