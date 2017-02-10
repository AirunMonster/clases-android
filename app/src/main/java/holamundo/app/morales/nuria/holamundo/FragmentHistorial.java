package holamundo.app.morales.nuria.holamundo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Android on 24/01/2017.
 */

public class FragmentHistorial extends Fragment {
    View rootView;
    EditText editText;
    Button button;
    EnviarMensaje EM;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_historial,container,false);

        editText = (EditText) rootView.findViewById(R.id.input);
        button = (Button) rootView.findViewById(R.id.botonEnviar);

//        EM = (EnviarMensaje) getActivity();     Esto también funciona si se caga con el onAttach o no se usa el onAttach()

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.botonEnviar:
                        String dato = editText.getText().toString();
                        EM.enviarDatos(dato);
                        break;
                    default:
                        break;
                }
            }
        });

        return rootView;
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        //EM = (EnviarMensaje) activity;
        try {
            EM = (EnviarMensaje) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }
}
