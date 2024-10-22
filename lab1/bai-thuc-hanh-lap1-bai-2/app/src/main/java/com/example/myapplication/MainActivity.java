package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        innitControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    private void innitControl(){
        bt= findViewById(R.id.bt);
        imageView = findViewById(R.id.imageView2);

        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random random = new Random();

                switch (random.nextInt(6)+1 ){
                    case 1:
                        imageView.setImageResource(R.drawable.d1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.d2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.d3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.d4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.d5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.d6);
                        break;

                }




            }
        });

    }
}