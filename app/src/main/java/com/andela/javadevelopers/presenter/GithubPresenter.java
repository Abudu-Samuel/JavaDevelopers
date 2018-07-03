package com.andela.javadevelopers.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.andela.javadevelopers.api.GithubApi;
import com.andela.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andeladeveloper on 03/07/2018.
 */

public class GithubPresenter {
    private static GithubPresenter GP = new GithubPresenter();

    private GithubApi developerService;

    private GithubPresenter() {
        if (this.developerService == null) {
            this.developerService = new GithubApi();
        }
    }

    public static GithubPresenter getInstance() {
        return GP;
    }

    public GithubPresenter getDevelopers() {
        developerService
                .getClient()
                .getItems()
                .enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<GithubUsersResponse> call, @NonNull Response<GithubUsersResponse> response) {
                        Log.e("GITHUB_USERS_LIST", String.valueOf(response.body().getGithubUsers()));

                    }

                    @Override
                    public void onFailure(@NonNull Call<GithubUsersResponse> call, @NonNull Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return null;
    }
}
