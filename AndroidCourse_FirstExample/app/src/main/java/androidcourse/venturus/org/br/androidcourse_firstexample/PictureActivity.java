package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        DownloadManager downloadManager = (DownloadManager)  getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://imgnzn-a.akamaized.net/2015/12/14/14173852787498.jpg"));
        downloadId = downloadManager.enqueue(request);

    }


}
