package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by vntlab on 7/19/16.
 */
public class ToastIntentService extends IntentService {

    private NotificationManager notificationManager;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ToastIntentService(String name) {
        super(name);
    }

    public ToastIntentService(){
        super("");
    }

    //Ira executar independente do app estar em segundo plano
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("debug", "onHandleIntent");
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        showNotification("Estou aqui");

        sleep();

        showNotification("Ainda estou aqui");

        sleep();

        showNotification("Tchau!");

        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showNotification(String message) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this).setContentTitle(message).setSmallIcon(R.mipmap.ic_launcher);
        notificationManager.notify(5556, builder.build());
    }
}
