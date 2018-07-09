package com.andela.javadevelopers.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.presenter.GithubPresenter;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Github presenter.
     */
    GithubPresenter githubPresenter = GithubPresenter.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        githubPresenter.getDevelopers();
    }
}
