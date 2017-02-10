package holamundo.app.morales.nuria.holamundo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    WebView webView;
    Button buttonNewScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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

        //Enlazamos el botón.
        buttonNewScreen = (Button) findViewById(R.id.botonNewScreen);
        buttonNewScreen.setOnClickListener(this);

        //Enlazamos el WebView y a continuación llamamos a la url.
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://ifraktal.com");
        /*webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/index.html");*/
        webView.setWebViewClient(new WebViewClient(){
            /*public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }*/
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request){
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonNewScreen:
                Toast.makeText(getApplicationContext(), "Cambiando de pantalla", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Main6Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
