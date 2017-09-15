package com.kevin.tech.kevinbase.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> for Project KevinBase on 2017/9/5.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class BaseApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
