package com.inteam.estrellawallet;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.inteam.estrellawallet.adapter.HistoryAdapter;
import com.inteam.estrellawallet.adapter.MyCatalogAdapter;
import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.entities.Expense;
import com.inteam.estrellawallet.domain.managers.UserManager;

import java.util.List;


public class HistoryActivity extends ListActivity {


    private int step;

    private List<Expense> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_catalog);
        TextView tvTitle = (TextView) findViewById(R.id.TV_choose);
        tvTitle.setText("Your expenses");
    }


    @Override
    protected void onStart() {
        super.onStart();
        UserManager um = new UserManager(this.getApplicationContext());
        expenses = um.getUser().getWallet().getListOfExpenses();

        HistoryAdapter adapter = new HistoryAdapter(this, expenses);
        setListAdapter(adapter);
    }
}
