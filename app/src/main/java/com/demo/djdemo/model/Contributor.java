package com.demo.djdemo.model;

/**
 * Created by Kros on 4/21/15.
 */
public class Contributor {
    String login;
    int contributions;

    @Override
    public String toString() {
        return "Repo{" +
                "login='" + login + '\'' +
                ", contributions=" + contributions +
                '}';
    }
}
