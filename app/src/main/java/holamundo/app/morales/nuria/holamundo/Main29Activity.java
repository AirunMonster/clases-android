package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main29Activity extends AppCompatActivity {
    EditText correo, titulo, texto;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarMail();
            }
        });

        correo = (EditText) findViewById(R.id.correo);
        titulo = (EditText) findViewById(R.id.titulo);
        texto = (EditText) findViewById(R.id.texto);
        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandarMail();
            }
        });
    }

    private void mandarMail() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.setData(Uri.parse("mailito:"));
        email.setType("text/plain");
        email.putExtra(Intent.EXTRA_EMAIL,correo.getText());
        email.putExtra(Intent.EXTRA_SUBJECT,titulo.getText());
        email.putExtra(Intent.EXTRA_TEXT,texto.getText());

        startActivity(Intent.createChooser(email,"Enviar eMail"));
    }
}
