package com.e.apptrainingchildren;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.e.apptrainingchildren.ui.theory.BaseFragmentTheory;

public class MainActivity extends AppCompatActivity {

    private BaseFragmentTheory baseFragmentTheory = new BaseFragmentTheory();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, baseFragmentTheory).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, baseFragmentTheory).commit();
        }
    }
}