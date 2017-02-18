package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Con ésto forzamos que la ventana de Splash se vea en posición vertical.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Iniciamos la Splash Activity que funcionará solo durante un periodo de tiempo TIMER.
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent().setClass(SplashActivity.this, Main19Activity.class);
                startActivity(intent);
                finish();
            }
        };

        // TIMER o duración en que la pantalla Splash estará activa. Le pasamos la tarea (task)
        // que hemos definido para dar vida a la Splash Activity.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
