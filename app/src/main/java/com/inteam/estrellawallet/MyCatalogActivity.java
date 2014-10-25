package com.inteam.estrellawallet;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.inteam.estrellawallet.adapter.CatalogAdapter;
import com.inteam.estrellawallet.adapter.MyCatalogAdapter;
import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.managers.CatalogManager;
import com.inteam.estrellawallet.domain.managers.UserManager;

import java.util.List;


public class MyCatalogActivity extends ListActivity {


    private int step;

    private List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_catalog);
    }


    @Override
    protected void onStart() {
        super.onStart();
        UserManager um = new UserManager(this.getApplicationContext());
        articles = um.getUser().getDesiredArticles();

        TextView tvTitle = (TextView) findViewById(R.id.TV_choose);
        tvTitle.setText("Your wants");

        MyCatalogAdapter adapter = new MyCatalogAdapter(this, articles);
        setListAdapter(adapter);
    }
}
