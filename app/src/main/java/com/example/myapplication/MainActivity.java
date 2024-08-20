package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText tx1,tx2;
    TextView txResult;
    Button btplus, btminus, btmulti,btdiv,btdu;

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

        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        txResult = findViewById(R.id.txResult);
        btplus = findViewById(R.id.btplus);
        btminus = findViewById(R.id.btminus);
        btmulti = findViewById(R.id.btmulti);
        btdiv = findViewById(R.id.btdiv);
        btdu = findViewById(R.id.btdu);

        btplus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x =  Integer.parseInt(tx1.getText().toString());
                int y = Integer.parseInt(tx2.getText().toString());
                int kq = x+y;
                txResult.setText(String.valueOf(kq));
            }
        });
        btminus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x =  Integer.parseInt(tx1.getText().toString());
                int y = Integer.parseInt(tx2.getText().toString());
                int kq = x-y;
                txResult.setText(String.valueOf(kq));
            }
        });
        btmulti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x =  Integer.parseInt(tx1.getText().toString());
                int y = Integer.parseInt(tx2.getText().toString());
                int kq = x*y;
                txResult.setText(String.valueOf(kq));
            }
        });
        btdiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x =  Integer.parseInt(tx1.getText().toString());
                int y = Integer.parseInt(tx2.getText().toString());
                int kq = x/y;
                txResult.setText(String.valueOf(kq));
            }
        });
        btdu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int x =  Integer.parseInt(tx1.getText().toString());
                int y = Integer.parseInt(tx2.getText().toString());
                int kq = x%y;
                txResult.setText(String.valueOf(kq));
            }
        });
    }
}