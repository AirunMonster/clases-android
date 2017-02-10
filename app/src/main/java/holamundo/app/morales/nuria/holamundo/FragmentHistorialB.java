package holamundo.app.morales.nuria.holamundo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Android on 24/01/2017.
 */

public class FragmentHistorialB extends Fragment {
    View rootView;
    TextView output;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_historial_b,container,false);

        output = (TextView) rootView.findViewById(R.id.output);

        return rootView;
    }

    public void recibir(String msg){
        output.setText(msg);
    }
}
