package com.inteam.estrellawallet;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
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
import com.inteam.estrellawallet.domain.managers.UserManager;

import java.util.List;


public class ConfigCatalogActivity extends ListActivity {


    private int step;

    private List<Article> articles;
    protected ConfigCatalogActivity activity;
    protected CatalogAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_catalog);
        //TODO : preguntar si ja estic registrat
        step = 1;
        activity = this;
    }


    @Override
    protected void onStart() {
        super.onStart();
        CatalogManager cm = new CatalogManager();
        articles = cm.getCatalog().getListOfArticles();
        adapter = new CatalogAdapter(this, articles);
        setListAdapter(adapter);

        LinearLayout layout = (LinearLayout) findViewById(R.id.catalog);
        layout.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            @Override
            public void onSwipeRight() {
                UserManager user = new UserManager(activity.getApplicationContext());

                for(int i = 0; i < articles.size(); ++i) {
                    if(adapter.selected_items.get(i)) {
                        user.addDesiredArticle(articles.get(i));
                    }
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                activity.finish();
            }

        });


    }


}
