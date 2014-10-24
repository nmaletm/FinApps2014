package com.inteam.estrellawallet.domain.managers;

import com.inteam.estrellawallet.domain.entities.Article;
import com.inteam.estrellawallet.domain.entities.Catalog;

public class CatalogManager {
    private Catalog catalog;
    public CatalogManager(){
        //  Instead of loading the data from the server
        //  now we generate dummy data.

        //this.loadCatalogFromServer();
        this.generateDummyCatalog();
    }

    private void generateDummyCatalog(){
        catalog.addArticle(new Article("Caritas",225,"url_photo_0"));
        catalog.addArticle(new Article("Botellín",500,"url_photo_1"));
        catalog.addArticle(new Article("Portagafas",550,"url_photo_2"));
        catalog.addArticle(new Article("MicroSD 8GB",700,"url_photo_3"));
        catalog.addArticle(new Article("Balón",875,"url_photo_4"));
        catalog.addArticle(new Article("Bidón",1075,"url_photo_5"));
        catalog.addArticle(new Article("Molde tarta",1250,"url_photo_6"));
        catalog.addArticle(new Article("Herramientas",1600,"photo_7"));
        catalog.addArticle(new Article("Termómetro",2550,"url_photo_8"));
        catalog.addArticle(new Article("Taladro",3125,"url_photo_9"));

        /*
        HashMap<String, Integer> photos;
        photos.put("url_photo_0",R.id.catalog_caritas);
        photos.put("url_photo_1",R.id.catalog_botellin);
        photos.put("url_photo_2",R.id.catalog_portagafas);
        photos.put("url_photo_3",R.id.catalog_microsd);
        photos.put("url_photo_4",R.id.catalog.balon);
        photos.put("url_photo_5",R.id.catalog_bidon);
        photos.put("url_photo_6",R.id.catalog_molde_tarta);
        photos.put("url_photo_7",R.id.catalog_herramientas);
        photos.put("url_photo_8",R.id.catalog_termometro);
        photos.put("url_photo_9",R.id.catalog_taladro);
        */
    }

    public Catalog getCatalog(){
        return this.catalog;
    }


}
