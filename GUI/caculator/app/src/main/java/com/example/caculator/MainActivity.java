package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    TextView txExp;
    TextView txResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initTv();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void initTv(){
        txExp = findViewById(R.id.txExp);
        txResult = findViewById(R.id.txResult);
    }
    private void cal(String exp){
        try {

            Expression ex = new ExpressionBuilder(exp).build();

            txResult.setText(String.valueOf(ex.evaluate()));
        }catch (Exception e){
            txResult.setText("Lỗi");
        }

    }
    private void setTxExp(String text){
       txExp.setText(txExp.getText().toString()+text);

    }

    //phep toan
    public void PlusClick(View view){setTxExp("+");}
    public void MinusClick(View view){setTxExp("-");}
    public void MultiplyClick(View view){setTxExp("*");}
    public void DivideClick(View view){setTxExp("/");}
    //chuc nang
    public void EqualClick(View view){ cal(txExp.getText().toString());}
    public void DelClick(View view){
        if(txExp.getText().toString().isEmpty()) return;
        txExp.setText(txExp.getText().toString().substring(0, txExp.getText().toString().length()-1));
    }
    public void CClick(View view){
        txExp.setText("");
        txResult.setText("");
    }

    //so
    public void ZeroClick(View view){setTxExp("0");}
    public void OneClick(View view){setTxExp("1");}
    public void TwoClick(View view){setTxExp("2");}
    public void ThreeClick(View view){setTxExp("3");}
    public void FourClick(View view){setTxExp("4");}
    public void FiveClick(View view){setTxExp("5");}
    public void SixClick(View view){setTxExp("6");}
    public void SevenClick(View view){setTxExp("7");}
    public void EightClick(View view){setTxExp("8");}
    public void NineClick(View view){setTxExp("9");}
    public void DotClick(View view){setTxExp(".");}
    public void OpenClick(View view){setTxExp("(");}
    public void CloseClick(View view){setTxExp(")");}

}