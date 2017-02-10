package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import java.io.IOException;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener{
    Button buttonIni, buttonFin, buttonNewScreen, buttonCalculadora, buttonFragment, buttonDibujar;
    MediaPlayer mediaPlayer = null;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
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

        buttonIni = (Button) findViewById(R.id.inicio);
        buttonFin = (Button) findViewById(R.id.fin);
        buttonNewScreen = (Button) findViewById(R.id.botonNewScreen);
        buttonCalculadora = (Button) findViewById(R.id.botonCalculadora);
        buttonFragment = (Button) findViewById(R.id.botonFragment);
        buttonDibujar = (Button) findViewById(R.id.botonDibujar);
        editText = (EditText) findViewById(R.id.editText);
//        mediaPlayer = MediaPlayer.create(this,R.raw.valkiries);

        buttonIni.setOnClickListener(this);
        buttonFin.setOnClickListener(this);
        buttonNewScreen.setOnClickListener(this);
        buttonCalculadora.setOnClickListener(this);
        buttonFragment.setOnClickListener(this);
        buttonDibujar.setOnClickListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(),charSequence,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    // Para seguir en pantalla de LOG del terminal con el fin de observar los estados de la Actividad 6 y 7.
    protected void onStart(){
        super.onStart();
        Log.d("onStart", "La bola entró - Primera base");
    }

    protected void onResume(){
        super.onResume();
        Log.d("onResume", "La bola entró - Primera base");
    }

    protected void onPause(){
        super.onPause();
        Log.d("onPause", "La bola entró - Primera base");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("onDestroy", "La bola entró - Primera base");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.inicio:
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.valkiries);
                    mediaPlayer.start();
                }
                break;
            case R.id.fin:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
                break;
            case R.id.botonNewScreen:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main10Activity.class);
                startActivity(intent);
                break;
            case R.id.botonCalculadora:
                Toast.makeText(getApplicationContext(), "Iniciando Calculadora", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Main7Activity.class);
                startActivity(intent1);
                break;
            case R.id.botonFragment:
                Toast.makeText(getApplicationContext(), "Iniciando ejemplo Fragment", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Main8Activity.class);
                startActivity(intent2);
                break;
            case R.id.botonDibujar:
                Toast.makeText(getApplicationContext(), "Iniciando ejemplo Dibujar Android", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Main9Activity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onStop();
        Log.d("onStop", "La bola entró - Primera base");
    }
}
