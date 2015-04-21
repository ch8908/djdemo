package com.demo.djdemo.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.demo.djdemo.BaseFragment;
import com.demo.djdemo.DemoApplication;
import com.demo.djdemo.GitHubService;
import com.demo.djdemo.R;
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
                System.out.println(">>>>>>>>>>>>>>>>>>> contributors = " + contributors);
            }
        });
        return rootView;
    }
}
