package com.andela.javadevelopers.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andeladeveloper on 29/06/2018.
 */

public class GithubUsersResponse {

    @SerializedName("items")
    @Expose
    private List<GithubUsers> githubUsers;

    public List<GithubUsers> getGithubUsers() {
        return githubUsers;
    }
}
