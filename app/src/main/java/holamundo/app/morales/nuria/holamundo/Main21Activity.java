package holamundo.app.morales.nuria.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main21Activity extends AppCompatActivity {

    ImageView imageViewA, imageViewB, imageViewC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);

        imageViewA = (ImageView) findViewById(R.id.imagen1);
        imageViewB = (ImageView) findViewById(R.id.imagen2);
        imageViewC = (ImageView) findViewById(R.id.imagen3);

        imageViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click Android",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click Buscar",Toast.LENGTH_SHORT).show();
            }
        });

        imageViewC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click Salir",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
