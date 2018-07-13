package com.andela.javadevelopers.network;

import com.andela.javadevelopers.home.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by andeladeveloper on 29/06/2018.
 */
public interface GithubService {
    /**
     * Gets items.
     *
     * @return the items
     */
    @GET("/search/users?q=language:java+location:lagos")
    Call<GithubUsersResponse> getItems();
}
