package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNum1,etNum2;
    TextView tvAnswer,tvSign;
    Button btnCalc,btnClear,btnPlus,btnMinus,btnMult,btnDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1=(EditText)findViewById(R.id.etNum1);
        etNum2=(EditText)findViewById(R.id.etNum2);
        tvAnswer=(TextView)findViewById(R.id.tvAnswer);
        tvSign=(TextView)findViewById(R.id.tvSign);


        btnCalc=(Button)findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);

        btnClear=(Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnPlus=(Button)findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(this);

        btnMinus=(Button)findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnMult=(Button)findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);

        btnDivide=(Button)findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);



    }

    @Override
    public void onClick(View v)
    {
        if(v==btnCalc)
        {
            if (etNum1.getText().toString().length() > 0 && etNum2.getText().toString().length() > 0)
            {
                int num1=Integer.valueOf(etNum1.getText().toString());
                int num2=Integer.valueOf(etNum2.getText().toString());
                double num3=0;
                if(tvSign.getText().toString()=="+")
                    num3 = num1 + num2;
                else if(tvSign.getText().toString()=="-")
                    num3 = num1 - num2;
                else if(tvSign.getText().toString()=="*")
                    num3 = num1 * num2;
                else if(tvSign.getText().toString()=="/")
                    num3 =(double)num1 / num2;
                else
                    Toast.makeText(this, "Enter a sign", Toast.LENGTH_LONG).show();
                tvAnswer.setText(String.valueOf(num3));
            }
            else
                Toast.makeText(this, "Enter numbers", Toast.LENGTH_LONG).show();
        }
        else if(v==btnPlus)
            tvSign.setText("+");
        else if(v==btnMinus)
            tvSign.setText("-");
        else if(v==btnMult)
            tvSign.setText("*");
        else if(v==btnDivide)
            tvSign.setText("/");
        else if(v==btnClear)
        {
            etNum1.setText("");
            etNum2.setText("");
            tvSign.setText("__");
            tvAnswer.setText("0");
        }
    }
}