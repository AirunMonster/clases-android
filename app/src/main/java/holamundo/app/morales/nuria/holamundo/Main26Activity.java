package holamundo.app.morales.nuria.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main26Activity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    Button  traslacion_button, rotacion_button, dilatacion_button, contraccion_button,
            aparicion_button, desaparicion_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);
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

        imageView = (ImageView) findViewById(R.id.imagen);
        traslacion_button = (Button) findViewById(R.id.botonIniTras);
        rotacion_button = (Button) findViewById(R.id.botonIniRota);
        dilatacion_button = (Button) findViewById(R.id.botonIniDila);
        contraccion_button = (Button) findViewById(R.id.botonIniContra);
        aparicion_button = (Button) findViewById(R.id.botonIniApa);
        desaparicion_button = (Button) findViewById(R.id.botonIniDes);

        traslacion_button.setOnClickListener(this);
        rotacion_button.setOnClickListener(this);
        dilatacion_button.setOnClickListener(this);
        contraccion_button.setOnClickListener(this);
        aparicion_button.setOnClickListener(this);
        desaparicion_button.setOnClickListener(this);
    }

    public void traslacion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.traslacion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    public void rotacion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotacion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    public void dilatacion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.dilatacion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    public void contraccion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.contraccion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    public void aparicion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.aparicion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    public void desaparicion() {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.desaparicion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.botonIniTras:
                traslacion();
                break;
            case R.id.botonIniRota:
                rotacion();
                break;
            case R.id.botonIniDila:
                dilatacion();
                break;
            case R.id.botonIniContra:
                contraccion();
                break;
            case R.id.botonIniApa:
                aparicion();
                break;
            case R.id.botonIniDes:
                desaparicion();
                break;
            default:
                break;
        }
    }
}
