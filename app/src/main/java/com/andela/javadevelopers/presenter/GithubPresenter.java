package com.andela.javadevelopers.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.andela.javadevelopers.api.GithubApi;
import com.andela.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * The type Github presenter.
 */
public final class GithubPresenter {
    /**
     * GithubPresenter.
     */
    private static GithubPresenter githubPresenter = new GithubPresenter();
    /**
     * GithubApi.
     */
    private GithubApi developerService;

    /**
     * GithubPresenter Method.
     */
    private GithubPresenter() {
        if (this.developerService == null) {
            this.developerService = new GithubApi();
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GithubPresenter getInstance() {
        return githubPresenter;
    }

    /**
     * Gets developers.
     *
     * @return the developers
     */
    public GithubPresenter getDevelopers() {
        developerService
                .getClient()
                .getItems()
                .enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<GithubUsersResponse> call,
                                           @NonNull Response<GithubUsersResponse> response) {
                        Log.e("GITHUB_USERS_LIST",
                                String.valueOf(response.body().getGithubUsers()));

                    }

                    @Override
                    public void onFailure(@NonNull Call<GithubUsersResponse> call,
                                          @NonNull Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            Log.e("error", "Something went wrong!");
                        }
                    }
                });
        return null;
    }
}
