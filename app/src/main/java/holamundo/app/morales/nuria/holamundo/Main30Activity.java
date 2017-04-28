package holamundo.app.morales.nuria.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main30Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Persona> personaList = new ArrayList<>();
    PersonaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main30);
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

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = (new LinearLayoutManager(this));
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        cargarDatos();
        adapter = new PersonaAdapter(this,personaList);
        recyclerView.setAdapter(adapter);
    }

    public void cargarDatos(){
        personaList.add(new Persona("Cersei","Lannister"));
        personaList.add(new Persona("Jaime","Lannister"));
        personaList.add(new Persona("Brien","Tarth"));
        personaList.add(new Persona("Walder","Fray"));
        personaList.add(new Persona("The","Haunt"));
        personaList.add(new Persona("Jon","Snow"));
        personaList.add(new Persona("Tyrion","Lannister"));
        personaList.add(new Persona("Daenerys","Targarien"));
        personaList.add(new Persona("Varys","The Spider"));
        personaList.add(new Persona("Little","Finger"));
        personaList.add(new Persona("Loras","Tyrell"));
        personaList.add(new Persona("Sam","Tarly"));
        personaList.add(new Persona("Margaery","Tyrell"));
        personaList.add(new Persona("Sansa","Stark"));
        personaList.add(new Persona("Arya","Stark"));
    }
}
