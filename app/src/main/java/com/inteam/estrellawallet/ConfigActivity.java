package com.inteam.estrellawallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class ConfigActivity extends Activity {


    private int step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_1);
        //TODO : preguntar si ja estic registrat
        step = 1;
        Toast.makeText(getApplicationContext(), "HOLA MAKI", Toast.LENGTH_LONG).show();
    }





    public void onClickSetBudget(View v) {
        step = 2;
        setContentView(R.layout.activity_config_2);
    }







}
