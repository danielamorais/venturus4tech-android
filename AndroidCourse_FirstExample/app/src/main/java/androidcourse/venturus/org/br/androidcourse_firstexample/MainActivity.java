package androidcourse.venturus.org.br.androidcourse_firstexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int numberLikes = 0;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //save status and update resource
        mPrefs = getSharedPreferences("arquivo_preferencias", Context.MODE_PRIVATE);
        numberLikes = mPrefs.getInt("num_likes", 0);
        String stringResource = getResources().getString(R.string.likeCount, numberLikes);
        final TextView textLikes = (TextView) findViewById(R.id.countLikes);
        textLikes.setText(stringResource);

        //update button on click
        final Button likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberLikes += 1;
                String stringResource = getResources().getString(R.string.likeCount, numberLikes);
                textLikes.setText(stringResource);
            }
        });

        //change activity
        ImageView robotImageView = (ImageView) findViewById(R.id.marshmallow_image);
        robotImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent pictureIntent = new Intent(MainActivity.this, PictureActivity.class);
                pictureIntent.putExtra("hello", 18);
                MainActivity.this.startActivity(pictureIntent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putInt("num_likes", numberLikes);
        editor.apply();
    }

}
