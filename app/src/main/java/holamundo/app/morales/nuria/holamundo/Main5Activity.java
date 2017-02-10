package holamundo.app.morales.nuria.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
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

        // Definimos los datos que vamos a utilizar en nuestra lista personalizada.
        // Los datos serán de tipo CursosProgramacion.
        CursosProgramacion cursosProgramacion_cursos[] = new CursosProgramacion[]{
                new CursosProgramacion(R.drawable.ic_launcher, "Java"),
                new CursosProgramacion(R.drawable.ic_launcher, "C++"),
                new CursosProgramacion(R.drawable.ic_launcher, "Phyton"),
                new CursosProgramacion(R.drawable.ic_launcher, "php"),
                new CursosProgramacion(R.drawable.ic_launcher, "SQL"),
                new CursosProgramacion(R.drawable.ic_launcher, "Swift"),
                new CursosProgramacion(R.drawable.ic_launcher, "Javascript"),
                new CursosProgramacion(R.drawable.ic_launcher, "Html"),
                new CursosProgramacion(R.drawable.ic_launcher, "CSS"),
                new CursosProgramacion(R.drawable.ic_launcher, "C#")
        };

        // Definimos el adaptador que vamos a utilizar.
        CursosProgramacionAdapter adapter = new CursosProgramacionAdapter(this,R.layout.listview_item_row,cursosProgramacion_cursos);

        // Definimos la ListView Personalizada.
        listView = (ListView) findViewById(R.id.listViewPersonal);

        // Definimos la cabecera de la lista.
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        // Añadimos la cabecera a la listView.
        listView.addHeaderView(header);
        // Asignamos el adaptador al listView.
        listView.setAdapter(adapter);
        // Si se pulsa encima de algún elemento de la lista aparecerá un mensaje de aviso con el nombre del curso.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.textList);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
