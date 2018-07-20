package com.andela.javadevelopers.home.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.home.adapter.DevListAdapter;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.andela.javadevelopers.home.presenter.GithubPresenter;
import com.andela.javadevelopers.userDetail.view.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    /**
     * The Github users parcel.
     */
    List<GithubUsers> githubUsersParcel;
    /**
     * PARCEL_KEY.
     */
    private static final String PARCEL_KEY = "java";

    /**
     * The Constraint layout.
     */
    @BindView(R.id.constraint_layout) ConstraintLayout constraintLayout;

    /**
     * The Swipe refresh layout.
     */
    @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeRefreshLayout;
    /**
     * .
     */
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    /**
     * ProgressDialog.
     */
    private ProgressDialog progressDialog;

    /**
     * The Github presenter.
     */
    MainContract.MainPresenter githubPresenter = new GithubPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        if (savedInstanceState != null) {
            githubUsersParcel = savedInstanceState.getParcelableArrayList(PARCEL_KEY);
            displayDevList(githubUsersParcel);
        } else {
            if (githubPresenter.getNetworkConnectionState()) {
                githubPresenter.queryApi();
            } else {
                displaySnackBar(false);
            }

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(PARCEL_KEY,
                (ArrayList<? extends Parcelable>) githubUsersParcel);
    }

    @Override
    public void displayDevList(List<GithubUsers> githubUsers) {
        githubUsersParcel = githubUsers;

        RecyclerView.Adapter adapter;
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new DevListAdapter(githubUsers, recyclerItemClickListener);
        recyclerView.setAdapter(adapter);
        Log.d("test", "message");
    }

    @Override
    public void showLoader() {
        progressDialog = ProgressDialog.show(this, "Java developers", "Loading...");
    }

    @Override
    public void hideLoader() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getViewContext() {
        return getApplicationContext();
    }

    /**
     * Display snack bar.
     *
     * @param networkStatus the network status
     */
    public void displaySnackBar(boolean networkStatus) {
        String status = "No internet connection";
        if (networkStatus) {
            status = "Bad connection";
        }
        Snackbar snackbar = Snackbar
                .make(swipeRefreshLayout, status, Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        githubPresenter.queryApi();
                    }
                });
        snackbar.show();
    }

    /**
     * RecyclerItem click event listener.
     */
    MainContract.RecyclerItemClickListener recyclerItemClickListener =
            new MainContract.RecyclerItemClickListener() {
                @Override
                public void onItemClick(GithubUsers githubUsers) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("githuber", githubUsers);
                    startActivity(intent);
                }
            };
}
