package com.inteam.estrellawallet;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.inteam.estrellawallet.adapter.CatalogAdapter;
import com.inteam.estrellawallet.domain.entities.Article;
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

    }





    public void onClickSetBudget(View v) {

        step = 2;
        setContentView(R.layout.activity_config_2);
    }







}
