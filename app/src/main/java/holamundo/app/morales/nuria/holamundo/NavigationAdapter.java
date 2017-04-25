package holamundo.app.morales.nuria.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Android on 13/03/2017.
 */

public class NavigationAdapter extends BaseAdapter {
    AppCompatActivity activity;
    ArrayList<Item> arrayList;

    public NavigationAdapter (AppCompatActivity activity, ArrayList<Item> arrayList){
        super();
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fila view;
        LayoutInflater inflater = activity.getLayoutInflater();
        if (convertView == null){
            view = new Fila();
            Item item = arrayList.get(position);
            convertView = inflater.inflate(R.layout.navigationdrawer_list,null);
            view.title = (TextView) convertView.findViewById(R.id.navitem);
            view.title.setText(item.getTitulo());

            view.icon = (ImageView) convertView.findViewById(R.id.icon);
            view.icon.setImageResource(item.getIcono());
            convertView.setTag(view);
        }
        else {
            view = (Fila) convertView.getTag();
        }
        return convertView;
    }

    public static class Fila {
        TextView title;
        ImageView icon;
    }
}
