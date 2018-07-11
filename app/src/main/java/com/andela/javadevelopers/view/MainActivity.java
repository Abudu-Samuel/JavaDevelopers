package com.andela.javadevelopers.view;

import android.app.ProgressDialog;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.adapter.DevListAdapter;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.model.GithubUsers;
import com.andela.javadevelopers.presenter.GithubPresenter;

import java.util.ArrayList;
import java.util.List;


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

        showLoader();
        if (savedInstanceState != null) {
            githubUsersParcel = savedInstanceState.getParcelableArrayList(PARCEL_KEY);
            displayDevList(githubUsersParcel);
            hideLoader();
        } else {
            githubPresenter.queryApi();
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

        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new DevListAdapter(githubUsers, this);
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
}
