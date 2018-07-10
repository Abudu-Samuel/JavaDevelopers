package com.andela.javadevelopers.presenter;

import android.support.annotation.NonNull;

import com.andela.javadevelopers.api.GithubApi;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.model.GithubUsers;
import com.andela.javadevelopers.model.GithubUsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * The type Github presenter.
 */
public final class GithubPresenter implements MainContract.MainPresenter {
    /**
     * The List items.
     */
    List<GithubUsers> listItems;
    /**
     * GithubApi.
     */
    private GithubApi developerService;

    /**
     * The M view.
     */
   private final MainContract.MainView mView;
    /**
     * GithubPresenter Method.
     *
     * @param mView - MainActivity view.
     */
    public GithubPresenter(MainContract.MainView mView) {
        this.mView = mView;
        if (this.developerService == null) {
            this.developerService = new GithubApi();
        }
    }


    /**
     * Gets developers.
     *
     */
    @Override
    public void queryApi() {
        developerService
                .getClient()
                .getItems()
                .enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<GithubUsersResponse> call,
                                           @NonNull Response<GithubUsersResponse> response) {

                       listItems = response.body().getGithubUsers();

                        mView.displayDevList(listItems);
                        mView.hideLoader();
                    }

                    @Override
                    public void onFailure(@NonNull Call<GithubUsersResponse> call,
                                          @NonNull Throwable t) {
                      mView.hideLoader();
                    }
                });
    }
}

