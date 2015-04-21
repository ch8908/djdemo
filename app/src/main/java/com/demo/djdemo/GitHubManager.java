package com.demo.djdemo;

import com.demo.djdemo.database.ContributorDao;
import com.demo.djdemo.model.Contributor;

import java.util.List;

/**
 * Created by Kros on 4/21/15.
 */
public class GitHubManager {
    private final ContributorDao dao;

    public GitHubManager(ContributorDao dao) {
        this.dao = dao;
    }

    public void saveContributors(List<Contributor> contributors) {
        dao.insertContributors(contributors);
    }
}
