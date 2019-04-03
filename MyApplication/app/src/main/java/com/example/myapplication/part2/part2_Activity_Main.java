package com.example.myapplication.part2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class part2_Activity_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2_main);

        Button secBtn= (Button)findViewById(R.id.part2_secActivity_Btn);

        secBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivity = new Intent(getApplicationContext(), part2_Activity_Sub.class);
                newActivity.putExtra("inputText", "HELLO WORLD!");
                startActivity(newActivity);
            }
        });

        Button gooleBtn = (Button)findViewById(R.id.part2_google_Btn);
        gooleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri  = "http://www.google.com";
                Uri web = Uri.parse(uri);
                Intent g = new Intent(Intent.ACTION_VIEW, web);

                if(g.resolveActivity(getPackageManager())!=null) {
                    startActivity(g);
                }
            }
        });
    }
}
