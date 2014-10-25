package com.inteam.estrellawallet;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.inteam.estrellawallet.adapter.CatalogAdapter;
import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.listeners.OnSwipeTouchListener;
import com.inteam.estrellawallet.domain.managers.CatalogManager;

import java.util.List;


public class ConfigCatalogActivity extends ListActivity {


    private int step;

    private List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_catalog);
        //TODO : preguntar si ja estic registrat
        step = 1;
    }


    @Override
    protected void onStart() {
        super.onStart();
        CatalogManager cm = new CatalogManager();
        articles = cm.getCatalog().getListOfArticles();
        CatalogAdapter adapter = new CatalogAdapter(this, articles);
        setListAdapter(adapter);

        LinearLayout layout = (LinearLayout) findViewById(R.id.catalog);
        Log.d("hello", "hu");
        layout.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeRight() {
                Log.d("hello", "hu");
                Intent intent = new Intent(getApplicationContext(), BudgetActivity.class);
                startActivity(intent);
            }

        });


    }





    public void onClickSetBudget(View v) {

        step = 2;
        setContentView(R.layout.activity_config_2);
    }







}
