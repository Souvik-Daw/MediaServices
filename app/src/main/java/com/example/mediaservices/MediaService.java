package com.example.mediaservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MediaService extends Service {
    private MediaPlayer player;


    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(this,R.raw.vp);


        player.setLooping(false);//stop the looping





    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }

    void musicPause()//pause music
    {
        if(player.isPlaying())
        player.pause();
        else
            player.start();
    }
}
