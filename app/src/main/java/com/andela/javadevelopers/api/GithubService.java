package com.andela.javadevelopers.api;

import com.andela.javadevelopers.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andeladeveloper on 29/06/2018.
 */

public interface GithubService {
    @GET("/search/users?q=language:java+location:lagos")
    Call<GithubUsersResponse> getItems();
}
