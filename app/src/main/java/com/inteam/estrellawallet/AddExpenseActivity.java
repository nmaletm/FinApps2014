package com.inteam.estrellawallet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.inteam.estrellawallet.domain.entities.User;
import com.inteam.estrellawallet.domain.managers.UserManager;

public class AddExpenseActivity extends Activity {

    private TextView mTextView;
    private UserManager um;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        um = new UserManager(this.getApplicationContext());
        um.setBudget(100);

        um = new UserManager(this.getApplicationContext());

        setContentView(R.layout.activity_add_expense);

        User user = um.getUser();

        int spent = 10;
        int points = user.pointsEarned(spent);

        int budget = user.getWallet().getBudget();
        String budgetText = budget + " €";
        ((TextView)findViewById(R.id.TV_add_budget)).setText(budgetText);

        String spentText = spent + " €";
        ((TextView)findViewById(R.id.TV_add_amount)).setText(spentText);

        String finalText = budget-spent + " €";
        ((TextView)findViewById(R.id.TV_add_final)).setText(finalText);


        ((TextView)findViewById(R.id.TV_add_points)).setText(points+"");
    }
}
