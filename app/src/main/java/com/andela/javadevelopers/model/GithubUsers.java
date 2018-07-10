package com.andela.javadevelopers.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andeladeveloper on 29/06/2018.
 */
public class GithubUsers {

    /**
     * Serialized name.
     */
    @SerializedName("avatar_url")
    @Expose
    private String userImage;

    /**
     * Serialized name.
     */
    @SerializedName("html_url")
    @Expose
    private String githubLink;

    /**
     * Serialized name.
     */
    @SerializedName("login")
    @Expose
    private String username;

    /**
     * Instantiates a new Github users.
     *
     * @param userImage  the user image
     * @param githubLink the github link
     * @param username   the username
     */
    public GithubUsers(String userImage, String githubLink, String username) {
        this.userImage = userImage;
        this.githubLink = githubLink;
        this.username = username;
    }

    /**
     * Gets user image.
     *
     * @return the user image
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets github link.
     *
     * @return the github link
     */
    public String getGithubLink() {
        return githubLink;
    }

    /**
     * Sets user image.
     *
     * @param userImage the user image
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    /**
     * Sets github link.
     *
     * @param githubLink the github link
     */
    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
