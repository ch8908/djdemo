package com.demo.djdemo;

import android.app.Application;

/**
 * Created by Kros on 4/21/15.
 */
public class DemoApplication extends Application {
    public static final String GIT_HUB_API_URL = "https://api.github.com";
    private static DemoComponent demoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        demoComponent = DaggerDemoComponent.builder()
                .networkModule(new NetworkModule(GIT_HUB_API_URL))
                .daoModule(new DaoModule(this))
                .build();
    }

    public static DemoComponent component() {
        return demoComponent;
    }
}
