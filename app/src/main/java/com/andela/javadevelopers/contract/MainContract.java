package com.andela.javadevelopers.contract;

import android.content.Context;

import com.andela.javadevelopers.home.model.GithubUsers;


import java.util.List;

/**
 * Created by andeladeveloper on 10/07/2018.
 */
public interface MainContract {
    /**
     * The interface Main view.
     */
    interface MainView {
        /**
         * Display dev list.
         *
         * @param githubUsers the github users
         */
        void displayDevList(List<GithubUsers> githubUsers);

        /**
         * Show loader.
         */
        void showLoader();

        /**
         * Hide loader.
         */
        void hideLoader();

        /**
         * Display snack bar.
         *
         * @param networkStatus the network status
         */
        void displaySnackBar(boolean networkStatus);

        /**
         * Gets context.
         *
         * @return the context
         */
        Context getViewContext();
    }

    /**
     * The interface Main presenter.
     */
    interface MainPresenter {
        /**
         * Query api github presenter.
         */
        void queryApi();

        /**
         * Gets network state.
         *
         * @return the network state
         */
        boolean getNetworkConnectionState();
    }

    /**
     * The interface Get github intractor.
     */
    interface GetGithubIntractor {

        /**
         * The interface On finished listener.
         */
        interface OnFinishedListener {
            /**
             * On finished.
             *
             * @param githubUsers the github users
             */
            void onFinished(List<GithubUsers> githubUsers);

            /**
             * On failure.
             *
             * @param throwable the throwable
             */
            void onFailure(Throwable throwable);
        }

        /**
         * Gets github list.
         *
         * @param onFinishedListener the on finished listener
         */
        void getGithubList(OnFinishedListener onFinishedListener);
    }


    /**
     * The interface Recycler item click listener.
     */
    interface RecyclerItemClickListener {
        /**
         * On item click.
         *
         * @param githubUsers the github users
         */
        void onItemClick(GithubUsers githubUsers);
    }
}
