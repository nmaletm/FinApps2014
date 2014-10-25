package com.inteam.estrellawallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.listeners.OnSwipeTouchListener;
import com.inteam.estrellawallet.domain.managers.UserManager;



public class MainActivity extends Activity {

    public enum ExitPoint {TOP, BOTTOM, RIGHT};

    private TextView mTextView;
    private ExitPoint exitPoint = ExitPoint.RIGHT;

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

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_layout);
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
                Intent intent = new Intent(getApplicationContext(), PointsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (exitPoint) {
            case TOP:
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
            break;
            case BOTTOM:
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
            break;
            case RIGHT:
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        switch (exitPoint) {
            case TOP:
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                break;
            case BOTTOM:
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
            case RIGHT:
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                break;
        }
    }
}
