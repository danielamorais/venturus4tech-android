package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vntlab on 7/19/16.
 */
public class PictureActivity extends AppCompatActivity {

    private long downloadId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        //get likes number
        Intent intent = getIntent();
        int numberLikes = intent.getIntExtra("numberLikes", 0);
        String stringResource = getResources().getString(R.string.likeCount, numberLikes);
        final TextView textLikes = (TextView) findViewById(R.id.numberLikes);
        textLikes.setText(stringResource);

        //ImageView anotherRobot = (ImageView) findViewById()
        //can't parse here 
        DownloadManager downloadManager = (DownloadManager)  getSystemService(DOWNLOAD_SERVICE);
        Uri address = Uri.parse("https://goo.gl/RnPVhk");
        DownloadManager.Request request = new DownloadManager.Request(address);
        downloadId = downloadManager.enqueue(request);

    }


}
