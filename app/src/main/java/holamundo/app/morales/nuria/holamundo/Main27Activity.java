package holamundo.app.morales.nuria.holamundo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Main27Activity extends AppCompatActivity implements SensorEventListener, View.OnClickListener{
    TextView x, y, z;
    Button acelerometro_button, brujula_button, giroscopio_button;
    SensorManager sensorManager;
    Sensor magnetometro, giroscopio;
    List<Sensor> sensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);
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

        x = (TextView) findViewById(R.id.x);
        y = (TextView) findViewById(R.id.y);
        z = (TextView) findViewById(R.id.z);

        acelerometro_button = (Button) findViewById(R.id.acelerometro);
        brujula_button = (Button) findViewById(R.id.brujula);
        giroscopio_button = (Button) findViewById(R.id.giroscopio);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        acelerometro_button.setOnClickListener(this);
        brujula_button.setOnClickListener(this);
        giroscopio_button.setOnClickListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                x.setText("Valor de x: "+ sensorEvent.values[SensorManager.DATA_X]);
                y.setText("Valor de y: "+ sensorEvent.values[SensorManager.DATA_Y]);
                z.setText("Valor de z: "+ sensorEvent.values[SensorManager.DATA_Z]);
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                x.setText("Valor de x: "+ sensorEvent.values[0]);
                y.setText("Valor de y: "+ sensorEvent.values[1]);
                z.setText("Valor de z: "+ sensorEvent.values[2]);
                break;
            case Sensor.TYPE_GYROSCOPE:
                x.setText("Valor de x: "+ sensorEvent.values[0]);
                y.setText("Valor de y: "+ sensorEvent.values[1]);
                z.setText("Valor de z: "+ sensorEvent.values[2]);
                break;
            default:
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.acelerometro:
                sensorList = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER); //Acelerómetro
                if (sensorList.size() > 0) {
                    sensorManager.registerListener((SensorEventListener) this,sensorList.get(0), SensorManager.SENSOR_DELAY_NORMAL);
                }
                break;
            case R.id.brujula:
                magnetometro = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); //Sensor de campo magnético
                sensorManager.registerListener(this,magnetometro,SensorManager.SENSOR_DELAY_NORMAL);
                break;
            case R.id.giroscopio:
                giroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE); //Giroscopio
                sensorManager.registerListener(this,giroscopio,SensorManager.SENSOR_DELAY_NORMAL);
                break;
            default:
                break;
        }
    }
}
