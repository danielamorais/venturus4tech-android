package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by vntlab on 7/19/16.
 */
public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent intent = getIntent();
        int numberLikes = intent.getIntExtra("numberLikes", 0);
        String stringResource = getResources().getString(R.string.likeCount, numberLikes);
        final TextView textLikes = (TextView) findViewById(R.id.numberLikes);
        textLikes.setText(stringResource);
    }


}
