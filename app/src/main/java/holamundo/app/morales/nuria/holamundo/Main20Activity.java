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

public class Main20Activity extends AppCompatActivity implements View.OnClickListener{
    Button buttonNewScreen, buttonEjEnviarEmail, buttonEjRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
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
        buttonEjEnviarEmail = (Button) findViewById(R.id.ejEnviarEmail);
        buttonEjRecyclerView = (Button) findViewById(R.id.ejRecyclerView);

        buttonNewScreen.setOnClickListener(this);
        buttonEjEnviarEmail.setOnClickListener(this);
        buttonEjRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonNewScreen:
                Toast toast = Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
                toast.show();
                Intent intent = new Intent(this, Main28Activity.class);
                startActivity(intent);
                break;
            case R.id.ejEnviarEmail:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Enviar eMail con Intent", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Main29Activity.class);
                startActivity(intent2);
                break;
            case R.id.ejRecyclerView:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Enviar eMail con Intent", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Main30Activity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }
    }
}
