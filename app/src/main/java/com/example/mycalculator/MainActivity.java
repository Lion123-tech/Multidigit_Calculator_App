package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private TextView exp;
    private TextView result;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button clear;
    private Button eto;
    private Button add;
    private Button sub;
    private Button division;
    private Button multiply;
    private String expression="";
    private String  pe="";
    private double val1=0;
    private double val2=0;
    private int priority(char ch)
    {
        if(ch=='*'||ch=='/')
            return 2;
        else if(ch=='+'||ch=='-')
            return 1;
        else
            return 0;

    }
    private void call1() {
        Stack<Double> n = new Stack<Double>();
        Stack<Character> s = new Stack<Character>();
        s.push('<');
        Scanner sc = new Scanner(System.in);String value="";double val=0.0,r=0.0;char ch;
        expression+=">";
        for(int i=0;i<expression.length();i++)
        {

            if(Character.isDigit(expression.charAt(i)))
            {
                pe+=expression.charAt(i);

            }
            else if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='/'||expression.charAt(i)=='*'||expression.charAt(i)=='>')
            {
                pe+="?";
                ch=s.peek();
                if(priority(expression.charAt(i))>priority(ch))
                    s.push(expression.charAt(i));
                else if(expression.charAt(i)=='>')
                    pe+=s.pop();
                else
                {
                    while(priority(expression.charAt(i))<=priority(ch)&&s.empty()==false)
                    {
                        pe+=s.pop();
                        ch=s.peek();
                    }
                    s.push(expression.charAt(i));
                }

            }

        }

        while(s.empty()==false&&s.peek()!='<')
        {
            pe+=s.pop();
        }
        if(s.empty()==false)
        {
            if(s.peek()=='<')
                s.pop();
        }
        for(int i=0;i<pe.length();i++)
        {
            if(Character.isDigit(pe.charAt(i)))
                value+=pe.charAt(i);
            else if(pe.charAt(i)=='?')
            {
                val=Double.parseDouble(value);
                n.push(val);
                value="";
            }
            else
            {
                double val2=n.pop();
                double val1=n.pop();
                if(pe.charAt(i)=='+')
                    r=val1+val2;
                else if(pe.charAt(i)=='-')
                    r=val1-val2;
                else if(pe.charAt(i)=='/')
                    r=val1/val2;
                else if(pe.charAt(i)=='*')
                    r=val1*val2;
                n.push(r);
            }
        }
        r=n.pop();
        expression="";
        pe="";
        result.setText(Double. toString(r));
    }
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exp=(TextView)findViewById(R.id.exp);
        result=(TextView)findViewById(R.id.result);
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        clear=(Button)findViewById(R.id.clear);
        eto=(Button)findViewById(R.id.equalto);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        division=(Button)findViewById(R.id.division);
        multiply=(Button)findViewById(R.id.multiply);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="1";
                exp.setText(expression);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="2";
                exp.setText(expression);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="3";
                exp.setText(expression);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="4";
                exp.setText(expression);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="5";
                exp.setText(expression);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="6";
                exp.setText(expression);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="7";
                exp.setText(expression);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="8";
                exp.setText(expression);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="9";
                exp.setText(expression);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="0";
                exp.setText(expression);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression="";
                exp.setText(expression);
                result.setText(expression);
            }
        });
        eto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(expression=="")
                     result.setText("0");
                 else call1();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="+";
                exp.setText(expression);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="-";
                exp.setText(expression);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="/";
                exp.setText(expression);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression+="*";
                exp.setText(expression);
            }
        });
    }
}