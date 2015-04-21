package com.demo.djdemo;

import com.demo.djdemo.ui.MainFragment;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Kros on 4/21/15.
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface DemoComponent {
    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

    void inject(MainFragment fragment);
}
