package randomappsinc.com.dishtac.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import randomappsinc.com.dishtac.Models.FontAwesomeViewHolder;
import randomappsinc.com.dishtac.R;

/**
 * Created by alexanderchiou on 11/15/15.
 */
public class NavDrawerAdapter extends BaseAdapter
{
    private String[] tabNames;
    private Context context;

    @SuppressWarnings("unchecked")
    public NavDrawerAdapter(Context context) {
        this.context = context;
        this.tabNames = context.getResources().getStringArray(R.array.nav_drawer_tabs);
    }

    @Override
    public int getCount() {
        return tabNames.length;
    }

    @Override
    public String getItem(int position) {
        return tabNames[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        FontAwesomeViewHolder holder;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.font_awesome_list_item, parent, false);
            holder = new FontAwesomeViewHolder(view);
            view.setTag(holder);
        }
        else {
            holder = (FontAwesomeViewHolder) view.getTag();
        }

        String tabName = tabNames[position];
        holder.itemName.setText(tabName);

        if (tabName.equals(context.getString(R.string.top_restaurants))) {
            holder.itemIcon.setText(context.getString(R.string.dish_icon));
        }
        else if (tabName.equals(context.getString(R.string.random_dish))) {
            holder.itemIcon.setText(context.getString(R.string.random_icon));
        }
        else if (tabName.equals(context.getString(R.string.settings))) {
            holder.itemIcon.setText(context.getString(R.string.settings_icon));
        }
        return view;
    }
}