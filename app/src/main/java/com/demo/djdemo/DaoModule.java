package com.demo.djdemo;

import android.app.Application;
import com.demo.djdemo.database.ContributorDao;
import com.demo.djdemo.database.DatabaseExecutor;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Kros on 4/21/15.
 */
@Module
public class DaoModule {
    private final Application application;

    public DaoModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    DatabaseExecutor provideDatabaseExecutor() {
        return new DatabaseExecutor(application);
    }

    @Provides
    @Singleton
    ContributorDao provideContributorDao(final DatabaseExecutor executor) {
        return new ContributorDao(executor);
    }
}
