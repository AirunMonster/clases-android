package holamundo.app.morales.nuria.holamundo;

/**
 * Created by Android on 13/03/2017.
 */

public class Item {
    String titulo;
    int icono;

    public Item (String titulo, int icono){
        this.titulo = titulo;
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono){
        this.icono = icono;
    }
}
