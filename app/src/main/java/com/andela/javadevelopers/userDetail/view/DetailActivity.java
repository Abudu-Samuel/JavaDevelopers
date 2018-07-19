package com.andela.javadevelopers.userDetail.view;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The type Detail activity.
 */
public class DetailActivity extends AppCompatActivity {
    /**
     * The Dev user name.
     */
    @BindView(R.id.userName) TextView devUserName;
    /**
     * The Dev user image.
     */
    @BindView(R.id.imageView) ImageView devUserImage;
    /**
     * The Dev github link.
     */
    @BindView(R.id.githubLink) TextView devGithubLink;
    /**
     * The User name.
     */
    private String userName;
    /**
     * The Git hub link.
     */
    private String gitHubLink;

    /**
     * The User image.
     */
    private String userImage;
    /**
     * Toolbar.
     */
    @BindView(R.id.toolbar_id) android.support.v7.widget.Toolbar toolbar;

    /**
     * The Collapsing toolbar layout.
     */
    @BindView(R.id.collapse_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        GithubUsers githubUsers = getIntent().getParcelableExtra("githuber");

        userName = githubUsers.getGithubLink();
        userImage = githubUsers.getUsername();
        gitHubLink = githubUsers.getUserImage();

        showProfile();

        getSupportActionBar().setTitle(userName);
    }

    /**
     * @return the IntentBuilder
     */
    private Intent createShareIntent() {
        StringBuilder shareMessage = new StringBuilder();
        shareMessage.append(getResources().getString(R.string.share_message))
                .append(userName).append(", ").append(gitHubLink);

        return ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(shareMessage)
                .getIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.commonmenu, menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        menuItem.setIntent(createShareIntent());
        return true;
    }

    /**
     * Display user github profile.
     */
    private void showProfile() {
        devUserName.setText(userName);
        devGithubLink.setText(gitHubLink);

        Glide
                .with(this)
                .load(userImage)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(devUserImage);
    }
}
