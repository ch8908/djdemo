package com.demo.djdemo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.demo.djdemo.*;
import com.demo.djdemo.model.Contributor;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Kros on 4/21/15.
 */
public class MainFragment extends BaseFragment {
    public MainFragment() {
    }

    @Inject GitHubService gitHubService;
    @Inject GitHubManager demoManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoApplication.component().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                List<Contributor> contributors = gitHubService.contributors("square", "retrofit");
                demoManager.saveContributors(contributors);
            }
        });
        return rootView;
    }
}
