package com.danielammorais.housecontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setIcon();

        Switch status = (Switch) findViewById(R.id.status);
        status.setChecked(true);
        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ImageView background = (ImageView) findViewById(R.id.background);
                ImageView icon = (ImageView) findViewById(R.id.iconLuz);
                TextView switchText = (TextView) findViewById(R.id.switchText);

                if(isChecked){
                    switchText.setText(R.string.switch_text_on);
                    background.setImageResource(R.drawable.bgon);
                    icon.setImageResource(R.drawable.icon_luz_on);
                } else {
                    switchText.setText(R.string.switch_text_off);
                    background.setImageResource(R.drawable.bgoff);
                    icon.setImageResource(R.drawable.icon_luz_off);
                }
            }
        });
    }

    private void setIcon() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setLogo(R.mipmap.launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            updateActionBarSubtitle(false);
        }
    }

    private void updateActionBarSubtitle(final boolean connected){
        if(getSupportActionBar() != null){
            getSupportActionBar().setSubtitle(connected ? getString(R.string.status_conectado) : getString(R.string.status_desconectado));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
