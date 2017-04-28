package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity implements View.OnClickListener{

    TextView textView, textViewResultado;
    Button buttonHistorial, buttonBorrar, buttonC, buttonParentesis, buttonPorCiento, buttonDividir,
            button7, button8, button9, buttonMultiplicar, button4, button5, button6, buttonMenos,
            button1, button2, button3, buttonMas, buttonDecimal, button0, buttonSigno, buttonIgual;
    Integer youCanDig = 1;
    Integer youCanSig = 1;
    Integer contadorNumeros = 0;
    Integer contadorOperandos = 0;
    Integer decimal = 0;
    Integer maxDigitos = 0;
    Boolean digito = false;
    private final static String LOG_TAG = Main7Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        buttonHistorial = (Button) findViewById(R.id.boton_historial);
        buttonBorrar = (Button) findViewById(R.id.boton_borrar);
        buttonC = (Button) findViewById(R.id.boton_C);
        buttonParentesis = (Button) findViewById(R.id.boton_parentesis);
        buttonPorCiento = (Button) findViewById(R.id.boton_por_ciento);
        buttonDividir = (Button) findViewById(R.id.boton_dividir);
        buttonDecimal = (Button) findViewById(R.id.boton_decimal);
        buttonMultiplicar = (Button) findViewById(R.id.boton_multiplicar);
        buttonMas = (Button) findViewById(R.id.boton_mas);
        buttonMenos = (Button) findViewById(R.id.boton_menos);
        buttonSigno = (Button) findViewById(R.id.boton_signo);
        buttonIgual = (Button) findViewById(R.id.boton_igual);
        button0 = (Button) findViewById(R.id.boton_0);
        button1 = (Button) findViewById(R.id.boton_1);
        button2 = (Button) findViewById(R.id.boton_2);
        button3 = (Button) findViewById(R.id.boton_3);
        button4 = (Button) findViewById(R.id.boton_4);
        button5 = (Button) findViewById(R.id.boton_5);
        button6 = (Button) findViewById(R.id.boton_6);
        button7 = (Button) findViewById(R.id.boton_7);
        button8 = (Button) findViewById(R.id.boton_8);
        button9 = (Button) findViewById(R.id.boton_9);

        buttonHistorial.setOnClickListener(this);
        buttonBorrar.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonParentesis.setOnClickListener(this);
        buttonPorCiento.setOnClickListener(this);
        buttonDividir.setOnClickListener(this);
        buttonDecimal.setOnClickListener(this);
        buttonMultiplicar.setOnClickListener(this);
        buttonMas.setOnClickListener(this);
        buttonMenos.setOnClickListener(this);
        buttonSigno.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    // Para seguir en pantalla de LOG del terminal con el fin de observar los estados de la Actividad 6 y 7.
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "La bola entró - Segunda base");
    }

    protected void onResume() {
        super.onResume();
        Log.d("onResume", "La bola entró - Segunda base");
    }

    protected void onPause() {
        super.onPause();
        Log.d("onPause", "La bola entró - Segunda base");
    }

    protected void onStop() {
        super.onStop();
        Log.d("onStop", "La bola entró - Segunda base");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy", "La bola entró - Segunda base");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_0:
                if (maxDigitos==0) {
                    Digitos(0);
                }
                break;
            case R.id.boton_1:
                if (maxDigitos==0) {
                    Digitos(1);
                }
                break;
            case R.id.boton_2:
                if (maxDigitos==0) {
                    Digitos(2);
                }
                break;
            case R.id.boton_3:
                if (maxDigitos==0) {
                    Digitos(3);
                }
                break;
            case R.id.boton_4:
                if (maxDigitos==0) {
                    Digitos(4);
                }
                break;
            case R.id.boton_5:
                if (maxDigitos==0) {
                    Digitos(5);
                }
                break;
            case R.id.boton_6:
                if (maxDigitos==0) {
                    Digitos(6);
                }
                break;
            case R.id.boton_7:
                if (maxDigitos==0) {
                    Digitos(7);
                }
                break;
            case R.id.boton_8:
                if (maxDigitos==0) {
                    Digitos(8);
                }
                break;
            case R.id.boton_9:
                if (maxDigitos==0) {
                    Digitos(9);
                }
                break;
            case R.id.boton_mas:
                if (maxDigitos==0) {
                    Operaciones("+");
                }
                break;
            case R.id.boton_menos:
                if (maxDigitos==0) {
                    Operaciones("-");
                }
                break;
            case R.id.boton_multiplicar:
                if (maxDigitos==0) {
                    Operaciones("*");
                }
                break;
            case R.id.boton_dividir:
                if (maxDigitos==0) {
                    Operaciones("/");
                }
                break;
            case R.id.boton_decimal:
                if (maxDigitos==0) {
                    if (decimal == 0) {
                        if (textView.length() == 0) {
                            textView.setText("0.");
                            decimal = 1;
                        } else {
                            textView.append(".");
                            decimal = 1;
                        }
                    }
                }
                break;
            case R.id.boton_C:
                textView.setText("");
                contadorNumeros = 0;
                contadorOperandos = 0;
                youCanDig = 1;
                youCanSig = 1;
                maxDigitos = 0;
                decimal = 0;
                break;
            case R.id.boton_borrar:
                String texto = textView.getText().toString();
                maxDigitos = 0;
                if (!texto.equals("")) {
                    if (texto.length() > 1) {
                        String ultimochar = texto.substring(texto.length() - 1, texto.length());
                        Comprobar_Borrar(ultimochar);
                        texto = texto.substring(0, texto.length() - 1);
                        textView.setText(texto);
                    } else {
                        textView.setText("");
                        contadorNumeros = 0;
                        contadorOperandos = 0;
                        youCanDig = 1;
                        youCanSig = 1;
                    }
                }
                break;
            case R.id.boton_signo:
                String texto2 = textView.getText().toString();
                // El texto está vacío
                if (texto2.equals("")){
                    textView.setText("(-");
                }
                else {
                    if (texto2.equals("(-")){
                        textView.setText("");
                    }
                    else {
                        // Ya hay texto. No viene en blanco.
                        // Si es dígito y true se añade (- por delante. Si es operación y true se añade (- por detrás.
                        Log.d(LOG_TAG, "Else: " + texto2);
                        if (digito) Log.d(LOG_TAG, "Digito Ok");
                        Encontrar_Indicador_Signo(texto2);
                    }
                }
                break;
            case R.id.boton_igual:
                break;
            default:
                break;
        }
        Log.d("Lenght",": "+textView.length());
        if (textView.length()>=70){
            Toast.makeText(Main7Activity.this, "Se ha superado el máximo número de dígitos: 70", Toast.LENGTH_SHORT).show();
            maxDigitos = 1;
        }
    }

    public void Digitos(Integer integer) {
        digito = true;
        if (youCanDig==1) {
            textView.append(integer.toString());
            contadorNumeros = contadorNumeros + 1;
            youCanSig=1;
            if (contadorOperandos >= 15) {
                youCanSig=0;
            }
            if (contadorNumeros > 14) {
                youCanDig = 0;
                Toast.makeText(Main7Activity.this, "Se ha superado el máximo número de digitos de un operador: 15", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(Main7Activity.this, "Se ha superado el máximo número de dígitos de un operador: 15", Toast.LENGTH_SHORT).show();
        }
    }

    public void Operaciones(String signo){
        digito=false;
        if (textView.getText().toString().isEmpty()) {
            Toast.makeText(Main7Activity.this, "Introduzca primero el operando.", Toast.LENGTH_SHORT).show();
        }
        else {
            if (youCanSig == 1) {
                textView.append(signo);
                decimal=0; //Inicializamos a 0 el contador de decimales para que el siguiente operando, si lo hay, pueda ser decimal.
                Comprobar_Operaciones();
                contadorNumeros = 0;
                youCanDig = 1;
                if (contadorOperandos > 14) {
                    youCanSig = 0;
                    Toast.makeText(Main7Activity.this, "Se ha superado el máximo número de operaciones: 15", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Main7Activity.this, "Se ha superado el máximo número de operaciones: 15", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Comprobar_Operaciones (){
        String aux, ultimo, penultimo, definitivo;

        aux = textView.getText().toString();
        if (aux.length()>2) {
            ultimo=aux.substring(aux.length()-1,aux.length());
            penultimo=aux.substring(aux.length()-2,aux.length()-1);
        }
        else {
            ultimo=aux.substring(1,aux.length());
            penultimo=aux.substring(0,aux.length()-1);
        }
        if (penultimo.equals("+") || penultimo.equals("-") || penultimo.equals("/") || penultimo.equals("*")) {
            definitivo = aux.substring(0,aux.length()-2)+ultimo;
            textView.setText(definitivo);
        }
        else {
            contadorOperandos = contadorOperandos + 1;
        }
    }

    public void Comprobar_Borrar (String lastchar) {
        if (lastchar.equals("+") || lastchar.equals("-") || lastchar.equals("/") || lastchar.equals("*")) {
            contadorOperandos = contadorOperandos - 1;
        }
        else {
            contadorNumeros = contadorNumeros -1;
            youCanDig=1;
        }
        //Comprobamos si han borrado un decimal. Si es así se marca por si quisieran poner otro que puedan hacerlo.
        if (lastchar.equals(".")){
            decimal = 0;
        }
    }

    public void Encontrar_Indicador_Signo (String texto){
        boolean flag = false;
        int i;
        String textoAuxiliar="";
        Log.d(LOG_TAG, "Texto: " + texto);
        Log.d(LOG_TAG, "Texto Length: " + texto.length());

        for (i = texto.length()-1; i >= 0; i--) {
            char aux = texto.charAt(i);
            Log.d(LOG_TAG, "aux: " + aux);
            Log.d(LOG_TAG, "i: " + i);
            if (flag) Log.d(LOG_TAG, "FLAG");
            if (aux == '-' | aux == '+' | aux == '*' | aux == '/') {
                flag = true;
            }
            if (aux == '(') {
                if (flag){
                    if (digito) {
                        /* Caso 4: Quitar (- por delante */
                        textoAuxiliar = texto.substring(0, i) + texto.substring(i + 2, texto.length());
                        textView.setText(textoAuxiliar);
                        Log.d(LOG_TAG, "TextView4: " + textView.getText().toString());
                    }
                    else {
                        /* Caso 6: Quitar (- por detras */
                        textoAuxiliar = texto.substring(0, i) + texto.substring(i + 2, texto.length());
                        textView.setText(textoAuxiliar);
                        Log.d(LOG_TAG, "TextView6: " + textView.getText().toString());
                    }
                }
            }
            else {
                if (flag) {
                    /* Caso 5:  Añadir (- por detrás. */
                    textoAuxiliar = texto.substring(0, i + 1) + "(-" + texto.substring(i + 1, texto.length());
                    textView.setText(textoAuxiliar);
                    Log.d(LOG_TAG, "TextView5: " + textView.getText().toString());
                }
                else {
                    /* Caso 3: Añadir (- por delante. */
                    textoAuxiliar = "(-" + texto;
                    textView.setText(textoAuxiliar);
                    Log.d(LOG_TAG, "TextView3: " + textView.getText().toString());
                }
            }
        }
    }
}
