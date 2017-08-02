package com.romeotutorial.ex2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox1.setChecked(getFromSP("cb1"));
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setChecked(getFromSP("cb2"));
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox3.setChecked(getFromSP("cb3"));
        checkBox3.setOnCheckedChangeListener(this);

    }


    private boolean getFromSP(String key){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Exercise2", Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }

    private void saveInSP(String key, boolean value){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("Exercise2", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.checkBox:
                saveInSP("cb1",b);
                break;
            case R.id.checkBox2:
                saveInSP("cb2",b);
                break;
            case R.id.checkBox3:
                saveInSP("cb3",b);
                break;
        }
    }
}