package holamundo.app.morales.nuria.holamundo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main15Activity extends AppCompatActivity {
    VideoView videoView, videoView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
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

        videoView = (VideoView) findViewById(R.id.videoView);
        videoView2 = (VideoView) findViewById(R.id.videoView2);

        videoView.setMediaController(new MediaController(this));
        Uri uri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        String path = "android.resource://" + getPackageName() + "/" + R.raw.video_ejemplo;
        videoView2.setMediaController(new MediaController(this));
        videoView2.setVideoURI(Uri.parse(path));
        videoView2.requestFocus();
        videoView2.start();
    }
}
