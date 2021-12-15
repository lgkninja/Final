package com.example.myapplication;

import static java.lang.Double.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Calculate extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        ToggleButton toggle = findViewById(R.id.toggleButton);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView3);

        AddAvg();
        acitveToggle();
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (toggle.isChecked())
                {
                    textView.setText(String.valueOf(getAverage()));
                }
                else
                {
                    textView.setText(String.valueOf(getSum()));
                }
            }
        });
    }
    private double getSum()
    {
        EditText edit = findViewById(R.id.editText);
        EditText edit2 = findViewById(R.id.editText2);
        EditText edit3 = findViewById(R.id.editText3);
        EditText edit4 = findViewById(R.id.editText4);
        EditText edit5 = findViewById(R.id.editText5);
        double num = Double.parseDouble((edit.getText().toString()));
        double num2 = Double.parseDouble((edit2.getText().toString()));
        double num3 = Double.parseDouble((edit3.getText().toString()));
        double num4 = Double.parseDouble((edit4.getText().toString()));
        double num5 = Double.parseDouble((edit5.getText().toString()));
        double sum = valueOf(num+num2+num3+num4+num5);
        return sum;
    }

    private double getAverage()
    {
        double sum = getSum();
        double average = sum/5;
        return average;
    }

    private void AddAvg()
    {
        SharedPreferences pref = getSharedPreferences("AddAvg Preferences", Context.MODE_PRIVATE);
        String add = pref.getString("add", "Addition");
        ToggleButton toggle = findViewById(R.id.toggleButton);
        if (add.equals("Addition"))
        {
            toggle.setChecked(false);
        }
        else
        {
            toggle.setChecked(true);
        }
    }
    private void acitveToggle()
    {
        ToggleButton toggle = findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (toggle.isChecked())
                {
                    SharedPreferences sp = getSharedPreferences("AddAvg Preferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("add","Average");
                    editor.apply();
                }
                else
                {
                    SharedPreferences sp = getSharedPreferences("AddAvg Preferences",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("add","Addition");
                    editor.apply();
                }
            }
        });
    }
}