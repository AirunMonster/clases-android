package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    //Definición de elementos a utilizar.
    Button buttonCheck;
    CheckBox checkBoxOne, checkBoxTwo, checkBoxThree;

    AutoCompleteTextView autoCompleteTextView;
    TextView textViewAuto;
    Button buttonAuto, buttonNewList, buttonNewScreen;

    String[] nombres = {"Juan", "Juanito", "Juanita", "Maria", "Maria Dolores", "Maria Jose", "Sancho", "Fernanda"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Este trozo de código del Toolbar y el FloatingActionButton es lo que hace que aparezca el texto
        // de "Clases Android" en la parte superior azul de la pantalla
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

        //Enlace de los elementos definidos en la parte lógica con los definidos en la parte física.
        buttonCheck = (Button) findViewById(R.id.buttonCheck);
        checkBoxOne = (CheckBox) findViewById(R.id.checkboxOne);
        checkBoxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkBoxThree = (CheckBox) findViewById(R.id.checkboxThree);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.auto);
        textViewAuto = (TextView) findViewById(R.id.textAuto);
        buttonAuto = (Button) findViewById(R.id.botonAuto);
        buttonNewScreen = (Button) findViewById(R.id.botonNewScreen);
        buttonNewList = (Button) findViewById(R.id.botonNewLista);


        //El botón será el disparador para lo que tenemos que hacer.
        buttonCheck.setOnClickListener(this);
        buttonAuto.setOnClickListener(this);
        buttonNewScreen.setOnClickListener(this);
        buttonNewList.setOnClickListener(this);

        //ArrayAdapter<String> lo creamos para rellenar el AutoCompleteTextView con el array nombres.
        //Como parámetros le pasamos el contexto (this), el estilo de relleno (simple_dropdown_item_1line), y los posibles valores (nombres).
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        //Utilizamos la función setThreshold para decirle en qué momento debe entrar la función de autocompletar.
        autoCompleteTextView.setThreshold(3);
        //Utilizamos la función setAdapter para indicarle al AutoCompleteTextView con qué se tiene que autocompletar.
        autoCompleteTextView.setAdapter(adapter);

        //Rellenamos el ListWiew con los elementos que tenemos definidos en nombres.
        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,nombres);
        listView.setAdapter(adapter1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonCheck:
                StringBuffer result = new StringBuffer();
                result.append(" Red:    ").append((checkBoxOne.isChecked()));
                result.append(" Blue:   ").append((checkBoxTwo.isChecked()));
                result.append(" Yellow: ").append((checkBoxThree.isChecked()));

                Toast.makeText(Main3Activity.this, result.toString(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonAuto:
                // Pasamos a carácteres cualquier cosa que nos pueda introducir el usuario para evitar errores.
                String cambio = autoCompleteTextView.getText().toString();
                //Cambiamos el texto por defecto por el nombre seleccionado.
                textViewAuto.setText(cambio);
                break;
            case R.id.botonNewScreen:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main4Activity.class);
                startActivity(intent);
                break;
            case R.id.botonNewLista:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intentb = new Intent(this, Main5Activity.class);
                startActivity(intentb);
                break;
            default:
                break;
        }
    }
}
