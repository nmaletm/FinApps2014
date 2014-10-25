package com.inteam.estrellawallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.listeners.OnSwipeTouchListener;
import com.inteam.estrellawallet.domain.managers.UserManager;



public class MainActivity extends SlidingActivity {


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        UserManager manager = new UserManager(getApplicationContext());
        if (!manager.hasBudget()) {
            Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
            startActivity(intent);
            this.finish();
        }

        TextView balance = (TextView) findViewById(R.id.balance_value);
        balance.setText("€ /" + "€");
        TextView points = (TextView) findViewById(R.id.points_value);
        points.setText("somanypoints");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout);
        layout.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeTop() {
                exitPoint = ExitPoint.TOP;
                Intent intent = new Intent(getApplicationContext(), AddExpenseActivity.class);
                startActivity(intent);
            }
            @Override
            public void onSwipeRight() {
                exitPoint = ExitPoint.RIGHT;
                Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
                startActivity(intent);
            }
            @Override
            public void onSwipeBottom() {
                exitPoint = ExitPoint.BOTTOM;
                Intent intent = new Intent(getApplicationContext(), MyCatalogActivity.class);
                startActivity(intent);
            }
        });
    }
}
