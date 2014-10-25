package com.inteam.estrellawallet;

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

        UserManager userManager = new UserManager(getApplicationContext());
        TextView balance = (TextView) findViewById(R.id.balance_value);
        balance.setText(userManager.getSpentLastWeek() + "€ /" + userManager.getUser().getWallet().getBudget() + "€");
        TextView points = (TextView) findViewById(R.id.points_value);
        points.setText(userManager.getUser().getPoints()+"");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_layout_main);
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

    @Override
    public void onResume() {
        super.onResume();

        UserManager userManager = new UserManager(getApplicationContext());
        TextView balance = (TextView) findViewById(R.id.balance_value);
        balance.setText(userManager.getSpentLastWeek() + "€ /" + userManager.getUser().getWallet().getBudget() + "€");
        TextView points = (TextView) findViewById(R.id.points_value);
        points.setText(userManager.getUser().getPoints()+"");
    }
}
