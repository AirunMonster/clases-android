package holamundo.app.morales.nuria.holamundo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Paint;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener {
    Button buttonNewScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
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
        buttonNewScreen.setOnClickListener(this);

        Vista vista = new Vista(this);
        setContentView(vista);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonNewScreen:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main10Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    class Vista extends View {
        float x=0;
        float y=0;
        String accion = "accion";
        Path path = new Path();

        public Vista(Context context){
            super(context);
        }

        public void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            paint.setColor(Color.BLUE);
            paint.setDither(true);

            if (accion=="down")
                path.moveTo(x,y);
            if (accion=="move")
                path.lineTo(x,y);

            int ancho = canvas.getWidth();
            canvas.drawRect(10,20,ancho-10,70,paint);
            canvas.drawPath(path,paint);
        }

        public boolean onTouchEvent(MotionEvent event){
            x=event.getX();
            y=event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN)
                accion="down";
            if (event.getAction() == MotionEvent.ACTION_MOVE)
                accion="move";

            invalidate();
            return true;
        }
    }
}
