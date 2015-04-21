package com.demo.djdemo;

import android.app.Application;

/**
 * Created by Kros on 4/21/15.
 */
public class DemoApplication extends Application {
    private static DemoComponent demoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        demoComponent = DaggerDemoComponent.builder()
                .networkModule(new NetworkModule("https://api.github.com"))
                .daoModule(new DaoModule(this))
                .build();
    }

    public static DemoComponent component() {
        return demoComponent;
    }
}
