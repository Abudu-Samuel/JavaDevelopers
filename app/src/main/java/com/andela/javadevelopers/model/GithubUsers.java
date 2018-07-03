package com.andela.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andeladeveloper on 29/06/2018.
 */

public class GithubUsers {

    @SerializedName("avatar_url")
    @Expose
    private String userImage;

    @SerializedName("html_url")
    @Expose
    private String githubLink;

    @SerializedName("login")
    @Expose
    private String username;

    public GithubUsers(String userImage, String githubLink, String username) {
        this.userImage = userImage;
        this.githubLink = githubLink;
        this.username = username;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUsername() {
        return username;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
