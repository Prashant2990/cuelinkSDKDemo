package com.cuelinksdemo.demo;

import android.app.Application;
import android.util.Log;

import com.cuelinks.Cuelinks;

/**
 * Created by tasneem on 25/05/16.
 */
public class CuelinksApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Cuelinks.initialize(this);
        Log.i("CuelinksApplication", "publisher id :"+ Cuelinks.getPublisherId());
    }
}
