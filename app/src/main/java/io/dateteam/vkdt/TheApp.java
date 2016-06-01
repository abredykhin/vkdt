package io.dateteam.vkdt;

import android.app.Application;

import com.vk.sdk.VKSdk;

public class TheApp extends Application {
    private static TheApp thisInstance;

    public static TheApp get() {
        return thisInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        thisInstance = this;

        VKSdk.initialize(this);
    }

}
