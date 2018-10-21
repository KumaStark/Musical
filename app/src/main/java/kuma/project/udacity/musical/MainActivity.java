package kuma.project.udacity.musical;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClickListener2Menu(findViewById(R.id.main_page));
    }

    private void setOnClickListener2Menu(View view) {
        ViewGroup touch_objs = (ViewGroup) view;
        for (int i = 0; i < touch_objs.getChildCount(); i++) {
            View touch_obj = touch_objs.getChildAt(i);
            touch_obj.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent();
        switch(view.getId()) {
            case R.id.btn_play_stop:
                i.setClass(this,PlayingListActivity.class);
                break;
            case R.id.btn_local_music:
                i.setClass(this,LocalMusicActivity.class);
                break;
            case R.id.btn_collection:
                i.setClass(this,CollectionsActivity.class);
                break;
            case R.id.btn_current:
                i.setClass(this,CurrentActivity.class);
                break;
            case R.id.btn_recognize:
                i.setClass(this,RecognizeActivity.class);
                break;
            default:
                Snackbar.make(view, "View(" + view.getId() + ") not ready !", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                break;
        }
        if(i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.app_settings) {
            Intent i = new Intent(this,SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
