package com.example.myapplication.part1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class part1_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);

        Button addBtn = (Button) findViewById(R.id.part1_addButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText)findViewById(R.id.part1_Num1_Text);
                EditText pw = (EditText)findViewById(R.id.part1_num2_Text);

                TextView result = findViewById(R.id.part1_resultTextBox);

                int num1 = Integer.parseInt(name.getText().toString());
                int num2 = Integer.parseInt(pw.getText().toString());

                result.setText(""+(num1+num2));
            }
        });


    }
}
