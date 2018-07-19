package com.andela.javadevelopers.contract;

import com.andela.javadevelopers.home.model.GithubUsers;

/**
 * Created by andeladeveloper on 18/07/2018.
 */
public interface RecyclerItemClickListener {
    /**
     * On item click.
     *
     * @param githubUsers the github users
     */
    void onItemClick(GithubUsers githubUsers);
}
