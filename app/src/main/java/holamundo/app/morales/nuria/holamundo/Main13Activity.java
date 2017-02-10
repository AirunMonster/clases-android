package holamundo.app.morales.nuria.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Main13Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ejemplo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.opcion1:
                Toast.makeText(getApplicationContext(),"Item 1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion2:
                Toast.makeText(getApplicationContext(),"Item 2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcionA:
                Toast.makeText(getApplicationContext(),"Opción A",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcionB:
                Toast.makeText(getApplicationContext(),"Opción B",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
