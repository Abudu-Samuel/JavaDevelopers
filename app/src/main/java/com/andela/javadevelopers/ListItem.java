package com.andela.javadevelopers;

/**
 * Created by andeladeveloper on 26/06/2018.
 */

public class ListItem {

    private String image;
    private String username;

    public ListItem(String image, String username) {
        this.image = image;
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }
}
