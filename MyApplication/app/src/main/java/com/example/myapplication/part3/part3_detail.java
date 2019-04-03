package com.example.myapplication.part3;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

import com.example.myapplication.R;

public class part3_detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_detail);

        if (getIntent().hasExtra("Index")) {
            scaleImg((ImageView) findViewById(R.id.part3_imageView), getImg(getIntent().getIntExtra("Index", -1)));
        }
    }

    private int getImg(int index){
        switch (index) {
            case 0:
                return R.drawable.peach;
            case 1:
                return R.drawable.tomato;
            case 2:
                return R.drawable.squash;
            default:
                return -1;
        }
    }

    private void scaleImg(ImageView img, int pic){
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.decodeResource(getResources(), pic, option);

        if(screen.getWidth()<option.outWidth) {
            int ratio = Math.round((float)option.outWidth / (float)screen.getWidth());
            option.inSampleSize = ratio;
        }
        option.inJustDecodeBounds = false;
        img.setImageBitmap(BitmapFactory.decodeResource(getResources(), pic, option));
    }
}
