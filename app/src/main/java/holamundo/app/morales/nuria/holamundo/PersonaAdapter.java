package holamundo.app.morales.nuria.holamundo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Android on 28/04/2017.
 */

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHorder> {
    Context context;
    List<Persona> personaList;

    public PersonaAdapter (Context context, List<Persona> personaList){
        this.context = context;
        this.personaList = personaList;
    }

    @Override
    public ViewHorder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHorder viewHolder = new ViewHorder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHorder holder, int position) {
        holder.nombre.setText(personaList.get(position).getNombre());
        holder.apellido.setText(personaList.get(position).getApellido());
    }

    @Override
    public int getItemCount() {
        return personaList.size();
    }

    public class ViewHorder extends RecyclerView.ViewHolder{
        TextView nombre, apellido;

        public ViewHorder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            apellido = (TextView) itemView.findViewById(R.id.apellido);
        }
    }
}
