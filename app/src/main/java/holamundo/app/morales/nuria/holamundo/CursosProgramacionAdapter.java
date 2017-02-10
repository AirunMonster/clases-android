package holamundo.app.morales.nuria.holamundo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Android on 30/11/2016.
 */

public class CursosProgramacionAdapter extends ArrayAdapter<CursosProgramacion> {
    Context myContext;
    int myLayoutResourceId;
    CursosProgramacion mycursos[] = null;

    // Constructor.
    public CursosProgramacionAdapter(Context context, int resource, CursosProgramacion[] cursos) {
        super(context, resource, cursos);

        this.myContext = context;
        this.myLayoutResourceId = resource;
        this.mycursos = cursos;
    }

    // Obtener elementos.
    public View getView (int position, View convertView, ViewGroup parent){
        //Cogemos la lista que está en convertView.
        View row = convertView;
        // Creamos un elemento holder y lo inicializamos a null.
        CursosProgramacionHolder holder = null;

        if (row == null){
            // Creamos un inflater que nos permite recoger la vista donde tenemos los elementos de la lista.
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row = inflater.inflate(myLayoutResourceId,parent,false);

            // Creamos el holder y pasamos los elementos de la vista al holder.
            holder = new CursosProgramacionHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imageList);
            holder.textView = (TextView) row.findViewById(R.id.textList);

            row.setTag(holder);

        }else {
            holder = (CursosProgramacionHolder)row.getTag();
        }

        CursosProgramacion cursosProgramacion = mycursos[position];
        holder.textView.setText(cursosProgramacion.title);
        holder.imagen.setImageResource(cursosProgramacion.icon);

        return row;
    }

    //Creamos el Holder que es como la estructura de nuestros elementos y que nos permitirá trabajar con ellos para recuperarlos.
    static class CursosProgramacionHolder {
        ImageView imagen;
        TextView textView;
    }
}
