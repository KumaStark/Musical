package kuma.project.udacity.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class CurrentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        setOnClickListener2Menu(findViewById(R.id.current_page));
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
        switch (view.getId()) {
            case R.id.desc_local_3:
                i.setClass(this, PlayingListActivity.class);
                break;
            case R.id.btn_nav_local_music_3:
                i.setClass(this, LocalMusicActivity.class);
                break;
            case R.id.btn_nav_collection_3:
                i.setClass(this, CollectionsActivity.class);
                break;
            case R.id.btn_nav_recognize_3:
                i.setClass(this, RecognizeActivity.class);
                break;
            default:
                break;
        }
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }
    }
}
