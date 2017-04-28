package holamundo.app.morales.nuria.holamundo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main22Activity extends AppCompatActivity {
    EditText texto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
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

        texto = (EditText) findViewById(R.id.editText);
        boton = (Button) findViewById(R.id.botonGuardar);

        SharedPreferences preferences = getSharedPreferences("apellidos", Context.MODE_PRIVATE);
        texto.setText(preferences.getString("dato", "No tenías nada en Preferencias."));

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dato = texto.getText().toString();
                SharedPreferences preferences = getSharedPreferences("apellidos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("dato", dato);
                editor.commit();
            }
        });
    }
}
