package com.andela.javadevelopers.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * The type Github api.
 */
public class GithubApi {

    /**
     * String BASE_URL.
     */
    private static final String BASE_URL = "https://api.github.com/";
    /**
     * Sting Retrofit.
     */
    private static Retrofit retrofit = null;

    /**
     * Gets client.
     *
     * @return the client
     */
    public GithubService getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubService.class);
    }
}
