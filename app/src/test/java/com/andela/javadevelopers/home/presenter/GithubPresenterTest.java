package com.andela.javadevelopers.home.presenter;
import com.andela.javadevelopers.contract.MainContract.MainPresenter;
import com.andela.javadevelopers.contract.MainContract.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by andeladeveloper on 23/07/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class GithubPresenterTest {
    /**
     * The Main view.
     */
    @Mock
    MainView mainView;

    /**
     * The Main presenter.
     */
    MainPresenter mainPresenter;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mainPresenter = new GithubPresenter(mainView);
    }

    /**
     * Call api.
     *
     * @throws Exception the exception
     */
    @Test
    public void callApi() throws Exception {

        mainPresenter.queryApi();
        Mockito.verify(mainView, Mockito.times(1)).showLoader();
    }
}
