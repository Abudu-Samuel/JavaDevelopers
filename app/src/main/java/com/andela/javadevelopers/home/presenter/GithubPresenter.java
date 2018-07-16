package com.andela.javadevelopers.home.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.andela.javadevelopers.network.GithubApi;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.andela.javadevelopers.home.model.GithubUsersResponse;
import com.andela.javadevelopers.util.Connectivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * The type Github presenter.
 */
public final class GithubPresenter implements MainContract.MainPresenter {
    /**
     * The List items.
     */
    List<GithubUsers> listItems;
    /**
     * GithubApi.
     */
    private GithubApi developerService;

    /**
     * The M view.
     */
    private final MainContract.MainView mView;

    /**
     * GithubPresenter Method.
     *
     * @param mView - MainActivity view.
     */
    public GithubPresenter(MainContract.MainView mView) {
        this.mView = mView;
        if (this.developerService == null) {
            this.developerService = new GithubApi();
        }
    }


    /**
     * Gets developers.
     */
    @Override
    public void queryApi() {
        mView.showLoader();
        developerService
                .getClient()
                .getItems()
                .enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(@NonNull Call<GithubUsersResponse> call,
                                           @Nullable Response<GithubUsersResponse> response) {
                        if (response != null) {
                            listItems = response.body().getGithubUsers();
                            mView.displayDevList(listItems);
                        } else {
                            mView.displaySnackBar(true);
                        }

                        mView.hideLoader();
                    }

                    @Override
                    public void onFailure(@NonNull Call<GithubUsersResponse> call,
                                          @NonNull Throwable t) {
                        mView.hideLoader();
                        mView.displaySnackBar(false);
                    }
                });
    }

    /**
     * Gets network state.
     *
     * @return the network state
     */
    public boolean getNetworkConnectionState() {
        return Connectivity.isConnected(mView.getViewContext());
    }
}
