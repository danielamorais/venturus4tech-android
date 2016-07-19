package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by vntlab on 7/19/16.
 */
public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent intent = getIntent();
        int passedInt = intent.getIntExtra("hello", 0);
        System.out.println("test intent ... " + passedInt);
    }


}
