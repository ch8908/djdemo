package com.demo.djdemo.database;

import com.demo.djdemo.model.Contributor;

import java.util.List;

/**
 * Created by Kros on 4/21/15.
 */
public class ContributorDao {
    private final DatabaseExecutor executor;

    public ContributorDao(DatabaseExecutor executor) {
        this.executor = executor;
    }

    public void insertContributors(List<Contributor> contributors) {
        System.out.println(">>>>>>>>>>>>>>>>>>> insert contributors to db:" + contributors);
        executor.execute();
    }
}
