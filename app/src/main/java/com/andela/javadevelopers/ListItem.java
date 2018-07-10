package com.andela.javadevelopers;


/**
 * The type List item.
 */
public class ListItem {
    /**
     * String image.
     */
    private final String image;
    /**
     * String username.
     */
    private final String username;
    /**
     * String githubLink.
     */
    private final String githubLink;

    /**
     * Instantiates a new List item.
     *
     * @param image    the image
     * @param username the username
     * @param githubLink the githubLink
     */
    public ListItem(String image, String username, String githubLink) {
        this.image = image;
        this.username = username;
        this.githubLink = githubLink;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
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

}
