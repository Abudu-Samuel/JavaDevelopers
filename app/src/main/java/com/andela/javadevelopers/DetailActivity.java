package com.andela.javadevelopers;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(this.getIntent().getStringExtra("USER_NAME"));

        showProfile();
    }

    private void showProfile() {
        Intent intent = this.getIntent();

        String userName = intent.getStringExtra("USER_NAME");
        String userImage = intent.getStringExtra("USER_IMAGE");
        String githubLink = intent.getStringExtra("GITHUB_LINK");

        TextView devUserName = findViewById(R.id.userName);
        ImageView devUserImage = findViewById(R.id.imageView);
        TextView devGithubLink = findViewById(R.id.githubLink);

        devUserName.setText(userName);
        devUserImage.setImageURI(Uri.parse(userImage));
        devGithubLink.setText(githubLink);


        Glide
                .with(this)
                .load(userImage)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(devUserImage);
    }
}
