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
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * The type Detail activity.
 */
public class DetailActivity extends AppCompatActivity {
    /**
     * The User name.
     */
    String userName;
    /**
     * The Git hub link.
     */
    String gitHubLink;
    /**
     * The Intent.
     */
    Intent intent;
    /**
     * Toolbar.
     */
    android.support.v7.widget.Toolbar toolbar;

    /**
     * The Collapsing toolbar layout.
     */
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = this.getIntent();

        toolbar = findViewById(R.id.toolbar_id);
        collapsingToolbarLayout = findViewById(R.id.collapse_toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
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
        userName = intent.getStringExtra("username");
        String userImage = intent.getStringExtra("user image");
        gitHubLink = intent.getStringExtra("github link");

        TextView devUserName = findViewById(R.id.userName);
        ImageView devUserImage = findViewById(R.id.imageView);
        TextView devGithubLink = findViewById(R.id.githubLink);

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
