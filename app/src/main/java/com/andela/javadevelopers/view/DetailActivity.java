package com.andela.javadevelopers.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.javadevelopers.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    String userName;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        intent = this.getIntent();

        showProfile();

        getSupportActionBar().setTitle(userName);
    }

    private void showProfile() {
        userName = intent.getStringExtra("USER_NAME");
        String userImage = intent.getStringExtra("USER_IMAGE");

        TextView devUserName = findViewById(R.id.userName);
        ImageView devUserImage = findViewById(R.id.imageView);

        devUserName.setText(userName);

        Glide
                .with(this)
                .load(userImage)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(devUserImage);
    }
}
