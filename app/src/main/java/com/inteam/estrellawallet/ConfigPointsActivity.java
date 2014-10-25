package com.inteam.estrellawallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class ConfigPointsActivity extends Activity {


    private int step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_1);
        //TODO : preguntar si ja estic registrat


    }





    public void onClickSetBudget(View v) {
        step = 2;
        setContentView(R.layout.activity_config_2);
    }







}
