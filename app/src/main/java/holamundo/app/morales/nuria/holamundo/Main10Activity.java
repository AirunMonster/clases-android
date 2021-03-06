package holamundo.app.morales.nuria.holamundo;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main10Activity extends AppCompatActivity implements View.OnClickListener{
    Button  buttonNewScreen, buttonVibrar, buttonFlash, buttonFlash15, buttonEjMenu,
            buttonEjMaterialDesing, buttonEjActionBar, buttonVideoView, buttonEjDatePicker,
            buttonEjRatingBar;
    Camera camera;
    boolean turnon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
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
        buttonVibrar = (Button) findViewById(R.id.botonVibrar);
        buttonFlash = (Button) findViewById(R.id.botonFlash);
        buttonFlash15 = (Button) findViewById(R.id.botonFlash15);
        buttonEjMenu = (Button) findViewById(R.id.ejMenu);
        buttonEjMaterialDesing = (Button) findViewById(R.id.ejMaterialDesing);
        buttonEjActionBar = (Button) findViewById(R.id.ejActionBar);
        buttonVideoView = (Button) findViewById(R.id.videoView);
        buttonEjDatePicker = (Button) findViewById(R.id.ejDatePicker);
        buttonEjRatingBar = (Button) findViewById(R.id.ejRatingBar);

        buttonNewScreen.setOnClickListener(this);
        buttonVibrar.setOnClickListener(this);
        buttonFlash.setOnClickListener(this);
        buttonFlash15.setOnClickListener(this);
        buttonEjMenu.setOnClickListener(this);
        buttonEjMaterialDesing.setOnClickListener(this);
        buttonEjActionBar.setOnClickListener(this);
        buttonVideoView.setOnClickListener(this);
        buttonEjDatePicker.setOnClickListener(this);
        buttonEjRatingBar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonNewScreen:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main11Activity.class);
                startActivity(intent);
                break;
            case R.id.botonVibrar:
                Vibrator vibrator = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
                long[] pattern = {0,100,1000,200,200,500,600,400,50,100,300,600,1000};
                if (vibrator.hasVibrator())
                {
                    Log.v("??Puede vibrar?", "Si puede");
                    vibrator.vibrate(pattern,-1);
                }
                else {
                    Log.v("??Puede vibrar?", "No puede");
                }
                break;
            case R.id.botonFlash:
                /*CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                if (!turnon) {
                    String cameraId = null; // Usually front camera is at 0 position.
                    try {
                        cameraId = camManager.getCameraIdList()[0];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        camManager.setTorchMode(cameraId, true);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    turnon = true;
                }
               else {
                    String cameraId2 = null;
                    try {
                        cameraId2 = camManager.getCameraIdList()[0];
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        camManager.setTorchMode(cameraId2, false);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                    turnon=false;
                }*/
                break;
            case R.id.botonFlash15:
                // Se supone que tiene que funcionar en Deprecate pero no se porque no funciona
                // por eso se ha buscado la soluci??n con Camera2 aunque implica que la versi??n
                // m??nima del sdk tiene que ser 23 as?? que para que funcione se ha modificado
                // build.gradle (Module: app) y en lugar de 15 se ha cambiado por 23.
                // if (camera == null) {
                if (!turnon){
                    try {
                        camera = Camera.open();
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        turnon = true;
                    } catch (RuntimeException e){
                        Log.e("Camara al Abrir error:",e.getMessage());
                        turnon = false;
                    }
                }
                else {
                    camera.stopPreview();
                    camera.release();
                    turnon = false;
                }
                break;
            case R.id.ejMenu:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Men??", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Main13Activity.class);
                startActivity(intent2);
                break;
            case R.id.ejMaterialDesing:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Material Desing", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Main12Activity.class);
                startActivity(intent3);
                break;
            case R.id.ejActionBar:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo Action Bar", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Main14Activity.class);
                startActivity(intent4);
                break;
            case R.id.videoView:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo VideoView", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Main15Activity.class);
                startActivity(intent5);
                break;
            case R.id.ejDatePicker:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo DatePicker", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, Main16Activity.class);
                startActivity(intent6);
                break;
            case R.id.ejRatingBar:
                Toast.makeText(getApplicationContext(), "Cambiando a Ejemplo RatingBar", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, Main17Activity.class);
                startActivity(intent7);
                break;
            default:
                break;
        }
    }
}
