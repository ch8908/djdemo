package com.demo.djdemo;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

import javax.inject.Singleton;

/**
 * Created by Kros on 4/21/15.
 */
@Module
public class NetworkModule {
    private final String gitHubBaseUrlString;

    public NetworkModule(final String gitHubBaseUrlString) {
        this.gitHubBaseUrlString = gitHubBaseUrlString;
    }

    @Provides
    @Singleton
    GitHubService provideGitHubService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(gitHubBaseUrlString)
                .build();
        return restAdapter.create(GitHubService.class);
    }
}
