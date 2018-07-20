package com.andela.javadevelopers.home.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by andeladeveloper on 29/06/2018.
 */
public class GithubUsers implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userImage);
        parcel.writeString(username);
        parcel.writeString(githubLink);
    }

    /**
     * Instantiates a new Github users.
     *
     * @param in the in
     */
    protected GithubUsers(Parcel in) {
        username = in.readString();
        githubLink = in.readString();
        userImage = in.readString();
    }

    /**
     * New array github users [ ].
     *
     * @param size the size
     * @return the github users [ ]
     */
    public GithubUsers[] newArray(int size) {
        return new GithubUsers[size];
    }

    /**
     * The constant CREATOR.
     */
    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel parcel) {
            return new GithubUsers(parcel);
        }

        @Override
        public GithubUsers[] newArray(int i) {
            return new GithubUsers[0];
        }
    };
}
