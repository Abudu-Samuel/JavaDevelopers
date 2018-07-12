package com.andela.javadevelopers.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andeladeveloper on 29/06/2018.
 */
public class GithubUsersResponse {

    /**
     * Serialize name.
     */
    @SerializedName("items")
    @Expose
    private List<GithubUsers> githubUsers;


    /**
     * Gets github users.
     *
     * @return the github users
     */
    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}
