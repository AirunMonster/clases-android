package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main11Activity extends AppCompatActivity implements View.OnClickListener{
    Button buttonNewScreen, buttonEjSplashScreen, buttonEjBotonProg, buttonEjBarraInf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
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

        buttonNewScreen = (Button) findViewById(R.id.botonNewScreen);
        buttonEjSplashScreen = (Button) findViewById(R.id.ejSplashScreen);
        buttonEjBotonProg = (Button) findViewById(R.id.ejBotonProg);
        buttonEjBarraInf = (Button) findViewById(R.id.ejBarraInf);

        buttonNewScreen.setOnClickListener(this);
        buttonEjBotonProg.setOnClickListener(this);
        buttonEjSplashScreen.setOnClickListener(this);
        buttonEjBarraInf.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonNewScreen:
                Toast toast = Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.RIGHT,0,0);
                toast.show();
                Intent intent = new Intent(this, Main20Activity.class);
                startActivity(intent);
                break;
            case R.id.ejBotonProg:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Elementos programación", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Main18Activity.class);
                startActivity(intent2);
                break;
            case R.id.ejSplashScreen:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo SplashScreen", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, SplashActivity.class);
                startActivity(intent3);
                break;
            case R.id.ejBarraInf:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Barra Inferior", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Main21Activity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
