package com.demo.djdemo;

import com.demo.djdemo.model.Contributor;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * Created by Kros on 4/21/15.
 */
public interface GitHubService {
    @GET("/repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );
}
