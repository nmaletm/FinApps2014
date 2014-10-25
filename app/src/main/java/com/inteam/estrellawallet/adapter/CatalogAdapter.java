package com.inteam.estrellawallet.adapter;


        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import android.graphics.Typeface;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.inteam.estrellawallet.ConfigCatalogActivity;
        import com.inteam.estrellawallet.R;
        import com.inteam.estrellawallet.domain.entities.Article;
        import com.inteam.estrellawallet.domain.managers.CatalogManager;


public class CatalogAdapter extends BaseAdapter{

    private ConfigCatalogActivity mContext;
    private List<Article> items;
    public List<Boolean> selected_items;
    private CatalogManager preferences;
    private Map<String, Integer> dummyPhotos;

    public CatalogAdapter(ConfigCatalogActivity activity, List<Article> newItems) {
        mContext = activity;
        items = newItems;
        selected_items = new ArrayList<Boolean>();
        for(int i = 0; i < items.size(); ++i) selected_items.add(false);

        dummyPhotos = new HashMap<String, Integer>();

        dummyPhotos.put("url_photo_0",R.drawable.catalog_caritas);
        dummyPhotos.put("url_photo_1",R.drawable.catalog_botellin);
        dummyPhotos.put("url_photo_2",R.drawable.catalog_portagafas);
        dummyPhotos.put("url_photo_3",R.drawable.catalog_microsd);
        dummyPhotos.put("url_photo_4",R.drawable.catalog_balon);
        dummyPhotos.put("url_photo_5",R.drawable.catalog_bidon);
        dummyPhotos.put("url_photo_6",R.drawable.catalog_molde_tarta);
        dummyPhotos.put("url_photo_7",R.drawable.catalog_herramientas);
        dummyPhotos.put("url_photo_8",R.drawable.catalog_termometro);
        dummyPhotos.put("url_photo_9",R.drawable.catalog_taladro);

        //preferences = new CatalogManager(activity.getApplicationContext());

    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolderItem holder;
        if(convertView == null){
            LayoutInflater vi = LayoutInflater.from(this.mContext);
            holder = new ViewHolderItem();
            convertView = vi.inflate(R.layout.list_element, null);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolderItem) convertView.getTag();
        }
        final Article article = items.get(position);
        if (article != null) {
            holder.background = (LinearLayout) convertView.findViewById(R.id.LL_achievement);
            if(position%2 == 0) holder.background.setBackgroundColor(mContext.getResources().getColor(R.color.light_blue));
            else holder.background.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            holder.selected= (View) convertView.findViewById(R.id.view_selected);
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            holder.name.setText(article.getName());
            holder.price = (TextView) convertView.findViewById(R.id.item_level);
            holder.price.setText(article.getPoints()+"");
            holder.image= (ImageView) convertView.findViewById(R.id.item_image);
            //Typeface type = Typeface.createFromAsset(mContext.getAssets(),"fonts/LuckiestGuy.ttf");
            //holder.price.setTypeface(type);
            //holder.name.setTypeface(type);

            int idImage = dummyPhotos.get(article.getUrlPhoto());
            holder.image.setImageResource(idImage);
            updateRow(article, holder, position);
            holder.background.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                    if(!selected_items.get(position)) {
                        selected_items.set(position, true);
                        holder.selected.setVisibility(View.VISIBLE);
                    }
                    else {
                        selected_items.set(position, false);
                        holder.selected.setVisibility(View.INVISIBLE);
                    }
                }

            });
        }
        return convertView;
    }


    public void updateRow(Article a, ViewHolderItem holder, int position) {
        if(selected_items.get(position)) {
            holder.selected.setVisibility(View.VISIBLE);
        }
        else {
            holder.selected.setVisibility(View.INVISIBLE);
        }
    }
}