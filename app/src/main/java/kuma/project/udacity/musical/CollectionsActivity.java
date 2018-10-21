package kuma.project.udacity.musical;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class CollectionsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        setOnClickListener2Menu(findViewById(R.id.collection_page));
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
            case R.id.desc_local_2:
                i.setClass(this, PlayingListActivity.class);
                break;
            case R.id.btn_nav_local_music_2:
                i.setClass(this, LocalMusicActivity.class);
                break;
            case R.id.btn_nav_current_2:
                i.setClass(this, CurrentActivity.class);
                break;
            case R.id.btn_nav_recognize_2:
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
