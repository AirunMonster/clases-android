package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    EditText editText;
    ImageView imageView;
    Button buttonTxt, buttonImg, buttonPan, buttonNTxt;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        buttonTxt = (Button) findViewById(R.id.button);
        buttonImg = (Button) findViewById(R.id.button2);
        buttonPan = (Button) findViewById(R.id.button3);
        buttonNTxt = (Button) findViewById(R.id.button4);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        buttonTxt.setOnClickListener(this);
        buttonImg.setOnClickListener(this);
        buttonPan.setOnClickListener(this);
        buttonNTxt.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton){
                    Toast.makeText(getApplicationContext(),"Pulsaste Primera Opci??n",Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radioButton2){
                    Toast.makeText(getApplicationContext(),"Pulsaste Segunda Opci??n",Toast.LENGTH_SHORT).show();
                } else if (i == R.id.radioButton3) {
                    Toast.makeText(getApplicationContext(),"Pulsaste Tercera Opci??n",Toast.LENGTH_SHORT).show();
                }
            }
        });

//        No sab??a que hab??a que definir el m??todo OnClick del OnClickListener en el View.class si quer??amos poner el implements View.OnClickListener
//        As?? que encontr?? esta otra soluci??n que funcionaba creando el OnClick para cada bot??n en lugar de usar el switch.
//        buttonTxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                Toast.makeText(getApplicationContext(),"Cambiando el texto",Toast.LENGTH_SHORT).show();
//                textView.setText("Hola a todo el mundo");
//            }
//        });
//        buttonImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                Toast.makeText(getApplicationContext(), "Cambiando la imagen", Toast.LENGTH_SHORT).show();
//                imageView.setImageResource(R.drawable.firefox);
//            }
//        });

//        Una soluci??n al problema de que el this no funcione al crear el intent tal y como lo pon??a en el curso es usando la declaraci??n de la variable mainThis
//        final MainActivity mainThis = this;
//        buttonPan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(mainThis,Main2Activity.class);
//                startActivity(intent);
//            }
//        });

//        La otra soluci??n que encontr?? en internet para no usar el this que daba error fu?? usar el actionName del AndroidManifest.
//        final MainActivity mainThis = this;
//        buttonPan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
//                String actionName= "android.intent.action.MAIN2ACTIVITY"; //Esto est?? definido en el AndroidManifest
//                Intent intent = new Intent(actionName);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Toast.makeText(getApplicationContext(),"Cambiando el texto",Toast.LENGTH_SHORT).show();
                textView.setText("Hola a todo el mundo");
                break;
            case R.id.button2:
                Toast.makeText(getApplicationContext(), "Cambiando la imagen", Toast.LENGTH_SHORT).show();
                imageView.setImageResource(R.drawable.firefox);
                break;
            case R.id.button3:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.button4:
                Toast.makeText(getApplicationContext(), "Cambiando el texto en pantalla nueva", Toast.LENGTH_SHORT).show();
                Intent intentPan = new Intent(this,Main2Activity.class);
                String datos = editText.getText().toString();
                intentPan.putExtra("DATOS", datos);
                startActivity(intentPan);
            default:
                break;
        }
    }
}
