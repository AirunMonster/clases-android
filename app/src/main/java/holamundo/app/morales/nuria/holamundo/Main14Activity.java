package holamundo.app.morales.nuria.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Main14Activity extends AppCompatActivity {

    private final static String LOG_TAG = Main14Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        Log.i(LOG_TAG,"onCreateOptionsMenu(Menu) Called");
        getMenuInflater().inflate(R.menu.menu_actionbar,menu);
        Log.v(LOG_TAG,"text changed to: "+LOG_TAG);
        Log.d(LOG_TAG,"onCreateOptionsMenu(Menu) Finished");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.action_settings:
                return true;
            case R.id.buscar:
                Toast.makeText(Main14Activity.this,"Le dimos a Buscar",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nuevo:
                Toast.makeText(Main14Activity.this,"Le dimos a Nuevo",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
}
