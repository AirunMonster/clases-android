package holamundo.app.morales.nuria.holamundo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    TextView textView2;
    Spinner spinner;
    ToggleButton toggleButton;
    Button buttonDialog, buttonDialogImg, buttonNewPant;
    Context context = Main2Activity.this; //Establecemos el contexto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        //Bundle
        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            String texto = (String) bundle.get("DATOS");
            textView2.setText(texto);
        }
        // Spinner
        spinner = (Spinner) findViewById(R.id.spinner);  // Enlazamos la parte lógica con la parte gráfica.
        List list = new ArrayList(); //Definimos una lista con un Array.
        list.add("Elemento 1");
        list.add("Elemento 2");
        list.add("Elemento 3");
        list.add("Elemento 4");
        list.add("Elemento 5");
        list.add("Elemento 6");
        list.add("Elemento 7");
        list.add("Elemento 8");

        //Creamos un ArrayAdapter que nos va a permitir colocar los elementos de la lista en el Spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Pasamos los datos del arrayAdapter al Spinner con lo que enlazamos la lista con la parte gráfica que es el Spinner.
        spinner.setAdapter(arrayAdapter);

        //La lista debe realizar alguna función por lo que esperamos a que uno de los items sea seleccionado
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this, "Posición " + String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Toggle Button
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton); //Enlazamos la parte lógica con la parte gráfica
        // Utilizamos setOnCheckedChangeListener para establecer cuando se modifica el estado del botón.
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(Main2Activity.this,"VERDADERO",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Main2Activity.this,"FALSO",Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Botón que lanza un Cuadro de diálogo
        buttonDialog = (Button) findViewById(R.id.buttonDialog); //Enlazamos la parte lógica con la parte gráfica
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // A partir de aquí lo que hacemos es configurar el Cuadro de Diálogo
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("¿Quieres continuar?")
                        .setCancelable(false)
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Sacamos un mensaje porque ha pulsado SI
                                Toast.makeText(context,"Has pulsado que quieres continuar",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Sacamos un mensaje porque ha pulsado NO
                                Toast.makeText(context,"Has pulsado que NO quieres continuar",Toast.LENGTH_SHORT).show();
                            }
                        });
                // A partir de aquí lo que hacemos es crear el cuadro de Diálogo y mostrárselo al usuario cuando haga click en el botón.
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        // Botón que lanza un Cuadro de diálogo con Imagen
        buttonDialogImg = (Button) findViewById(R.id.buttonDialogImg); //Enlazamos la parte lógica con la parte gráfica
        buttonDialogImg.setOnClickListener(this);

        //Botón que lanza una Nueva Pantalla y que se ejecutará en el OnClick
        buttonNewPant = (Button) findViewById(R.id.buttonNewPant);
        buttonNewPant.setOnClickListener(this);
    }

    // Renombramos el método onCreateDialog para que funcione de otra manera.
    protected Dialog onCreateDialog (int id){
        Dialog dialog = null; //Inicializamos el diálogo a null
        // A partir de aquí configuramos el cuadro de Diálogo con Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder = builder.setIcon(R.drawable.google_android);
        builder = builder.setTitle("Mi diálogo con Imagen");
        // Con el create, creamos el cuadro de Diálogo.
        dialog = builder.create();

        return (dialog);
    }

    @Override
    public void onClick(View view) {
        // Le indicamos al dialogo que se active
        showDialog(0);
        // Comprobamos el botón de Nueva Pantalla
        switch (view.getId()) {
            case R.id.buttonNewPant:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main3Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
