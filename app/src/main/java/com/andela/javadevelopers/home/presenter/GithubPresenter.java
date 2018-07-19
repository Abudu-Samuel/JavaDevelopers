package com.andela.javadevelopers.home.presenter;

import com.andela.javadevelopers.home.model.GetGithubUserIntractor;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.andela.javadevelopers.util.Connectivity;

import java.util.List;

/**
 * The type Github presenter.
 */
public final class GithubPresenter implements MainContract.MainPresenter,
        MainContract.GetGithubIntractor.OnFinishedListener {

    /**
     * The M view.
     */
    private final MainContract.MainView mView;
    /**
     * Intractor.
     */
    private final MainContract.GetGithubIntractor intractor;

    /**
     * GithubPresenter Method.
     *
     * @param mView - MainActivity view.
     */
    public GithubPresenter(MainContract.MainView mView) {
        this.mView = mView;
        this.intractor = new GetGithubUserIntractor();
    }


    /**
     * Gets developers.
     */
    @Override
    public void queryApi() {
        mView.showLoader();
        intractor.getGithubList(this);
    }

    /**
     * Gets network state.
     *
     * @return the network state
     */
    public boolean getNetworkConnectionState() {
        return Connectivity.isConnected(mView.getViewContext());
    }

    @Override
    public void onFinished(List<GithubUsers> githubUsers) {
        if (githubUsers == null) {
            mView.displaySnackBar(true);
        } else {
            mView.hideLoader();
            mView.displayDevList(githubUsers);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        mView.hideLoader();
        mView.displaySnackBar(false);
    }
}
