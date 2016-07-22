    package androidcourse.venturus.org.br.androidcourse_firstexample;

    import android.Manifest;
    import android.app.DownloadManager;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.content.pm.PackageManager;
    import android.net.Uri;
    import android.os.Bundle;
    import android.support.v4.app.ActivityCompat;
    import android.support.v4.content.ContextCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.widget.TextView;
    import android.widget.Toast;

    /**
     * Created by vntlab on 7/19/16.
     */
    public class PictureActivity extends AppCompatActivity {

        private static int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
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

            //request for permissions
            //checkPermissionAndDownload();
        }

        //works only at Android 6.0
        /*
        private void checkPermissionAndDownload() {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "blalblalbla", Toast.LENGTH_LONG).show();
                }
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            } else {
                    doDownload();
            }
        }
        */

        private void doDownload() {
            DownloadManager downloadManager = (DownloadManager)  getSystemService(DOWNLOAD_SERVICE);
            Uri address = Uri.parse("https://goo.gl/RnPVhk");
            DownloadManager.Request request = new DownloadManager.Request(address);
            downloadId = downloadManager.enqueue(request);
            registerReceiver(new DownloadCompleteReceiver(downloadId), new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        }
    }
