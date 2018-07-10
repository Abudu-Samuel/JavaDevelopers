package com.andela.javadevelopers.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
     * The Intent.
     */
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = this.getIntent();

        showProfile();

        getSupportActionBar().setTitle(userName);
    }

    /**
     * Display user github profile.
     */
    private void showProfile() {
        userName = intent.getStringExtra("username");
        String userImage = intent.getStringExtra("user image");
        String gitHubLink = intent.getStringExtra("github link");

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
