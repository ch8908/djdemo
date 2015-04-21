package com.demo.djdemo;

import com.demo.djdemo.database.ContributorDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Kros on 4/21/15.
 */
@Module
public class LogicModule {
    @Provides
    @Singleton
    GitHubManager provideGitHubService(ContributorDao dao) {
        return new GitHubManager(dao);
    }
}
