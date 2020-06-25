package com.example.block04_music_control;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    MediaPlayer songPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlay=(Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic();
            }
        });
        Button btnPause=(Button) findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseMusic();
            }
        });
        songPlay = MediaPlayer.create(this, R.raw.song);
        Switch swh_looping = (Switch) findViewById(R.id.swh_looping);
        swh_looping.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                songPlay.setLooping(isChecked);
            }
        });

        

    }
    public void playMusic()
    {
        songPlay.start();
    }
    public void pauseMusic()
    {
        if (songPlay.isPlaying())
        {
            songPlay.pause();
        }
    }
}