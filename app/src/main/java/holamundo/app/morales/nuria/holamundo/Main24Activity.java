package holamundo.app.morales.nuria.holamundo;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Main24Activity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView navList;
    TypedArray navIcons;
    String[] titulos;
    ArrayList<Item> navItems;
    NavigationAdapter navAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.content_main24);
        navList = (ListView) findViewById(R.id.navlist);

        View header = getLayoutInflater().inflate(R.layout.navigationdrawer_header,null);
        navList.addHeaderView(header);

        navIcons = getResources().obtainTypedArray(R.array.icons);
        titulos = getResources().getStringArray(R.array.titulos);

        navItems = new ArrayList<Item>();

        navItems.add(new Item(titulos[0],navIcons.getResourceId(0,-1)));
        navItems.add(new Item(titulos[1],navIcons.getResourceId(1,-1)));
        navItems.add(new Item(titulos[2],navIcons.getResourceId(2,-1)));
        navItems.add(new Item(titulos[3],navIcons.getResourceId(3,-1)));
        navItems.add(new Item(titulos[4],navIcons.getResourceId(4,-1)));
        navItems.add(new Item(titulos[5],navIcons.getResourceId(5,-1)));
        navItems.add(new Item(titulos[6],navIcons.getResourceId(6,-1)));
        navItems.add(new Item(titulos[7],navIcons.getResourceId(7,-1)));
        navItems.add(new Item(titulos[8],navIcons.getResourceId(8,-1)));

        navAdapter = new NavigationAdapter(this,navItems);
        navList.setAdapter(navAdapter);
    }
}
