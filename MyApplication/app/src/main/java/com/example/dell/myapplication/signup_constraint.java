package com.example.dell.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_constraint extends AppCompatActivity {
    Button btn;
    TextView btn2;
    private boolean male=false;
    private boolean female=false;
    private Matcher matcher;
    private static Pattern pattern;
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    RadioButton btn1;
    RadioButton btn3;
    private boolean chk;
    private boolean rbt;
    private String email;
    private String password;
    private String gender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_relative);
        function1();
        function2();
        function3();
    }
    public void function1() {
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chk=((CheckBox)findViewById(R.id.checkBox2)).isChecked();
                if(chk==true) {
                    btn2 = (TextView) findViewById(R.id.editText3);
                    email = btn2.getText().toString();
                    btn2 = (TextView) findViewById(R.id.editText4);
                    password = btn2.getText().toString();
                    btn1 = (RadioButton) findViewById(R.id.radioButton3);
                    male = btn1.isChecked();
                    btn3 = (RadioButton) findViewById(R.id.radioButton4);
                    female = btn3.isChecked();
                    if (male == true)
                    {
                        gender=btn1.getText().toString();
                        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
                        matcher = pattern.matcher(email);
                        if(matcher.matches()==true)
                        {
                            Toast.makeText(getApplicationContext(), "Email: " + email + " -Password: " + password+" -Gender: "+gender , Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Email is invalid!"  , Toast.LENGTH_LONG).show();
                        }
                    }
                    else if(female==true)
                    {
                        gender=btn3.getText().toString();
                        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
                        matcher = pattern.matcher(email);
                        if(matcher.matches()==true)
                        {
                            Toast.makeText(getApplicationContext(), "Email: " + email + " -Password: " + password+" -Gender: "+gender , Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Email is invalid!"  , Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Please select the gender!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"The user should check Terms&Conditions.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void function2() {
        btn1=(RadioButton)findViewById(R.id.radioButton3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbt=((RadioButton)findViewById(R.id.radioButton3)).isChecked();
                if(rbt==true) {
                    btn1 = (RadioButton) findViewById(R.id.radioButton4);
                    btn1.setChecked(false);
                }
            }
        });
    }
    public void function3() {
        btn1=(RadioButton)findViewById(R.id.radioButton4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbt=((RadioButton)findViewById(R.id.radioButton4)).isChecked();
                if(rbt==true) {
                    btn1 = (RadioButton) findViewById(R.id.radioButton3);
                    btn1.setChecked(false);
                }
            }
        });
    }
}
