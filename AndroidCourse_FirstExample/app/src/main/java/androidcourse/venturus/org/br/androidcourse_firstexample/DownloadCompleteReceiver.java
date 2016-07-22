package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DownloadCompleteReceiver extends BroadcastReceiver {
    private long downloadId = -1;

    public DownloadCompleteReceiver(long downloadId) {
        this.downloadId = downloadId;
    }

    public DownloadCompleteReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)){
            long downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
            if(downId == downloadId){
                Toast toast = Toast.makeText(context, R.string.image_download, Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
