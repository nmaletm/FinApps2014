package com.inteam.estrellawallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.listeners.OnSwipeTouchListener;
import com.inteam.estrellawallet.domain.managers.UserManager;



public class MainActivity extends SlidingActivity {

    private boolean showMyCatalog;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        UserManager userManager = new UserManager(getApplicationContext());
        if (!userManager.hasBudget()) {
            Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
            startActivity(intent);
            this.finish();
        }


        RelativeLayout layout = (RelativeLayout) findViewById(R.id.main_main);
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
    protected void onStart() {
        super.onStart();

        UserManager userManager = new UserManager(getApplicationContext());
        showMyCatalog = (userManager.getUser().getDesiredArticles().size() > 0);

        if(!showMyCatalog){
            ((ImageButton) findViewById(R.id.imageButtonBottom)).setVisibility(View.INVISIBLE);
        } else {
            ((ImageButton) findViewById(R.id.imageButtonBottom)).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        UserManager userManager = new UserManager(getApplicationContext());
        int budget = userManager.getUser().getWallet().getBudget();

        TextView balance = (TextView) findViewById(R.id.balance_value);
        balance.setText(budget-userManager.getSpentLastWeek()+"");
        TextView budgetView = (TextView) findViewById(R.id.budget_value);
        budgetView.setText("/" + budget + "€");
        TextView points = (TextView) findViewById(R.id.points_value);
        points.setText(userManager.getUser().getPoints()+"");
    }

    public void onClickTopButton(View v) {
        Intent intent = new Intent(getApplicationContext(), AddExpenseActivity.class);
        startActivity(intent);
    }

    public void onClickRightButton(View v) {
        Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
        startActivity(intent);
    }

    public void onClickBottomButton(View v) {
        Intent intent = new Intent(getApplicationContext(), MyCatalogActivity.class);
        startActivity(intent);
    }


    public void onClickHistory(View v) {
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }
}
