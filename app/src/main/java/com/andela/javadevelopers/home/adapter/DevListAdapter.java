package com.andela.javadevelopers.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.andela.javadevelopers.userDetail.view.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


/**
 * The type Dev list adapter.
 */
public class DevListAdapter extends RecyclerView.Adapter<DevListAdapter.ViewHolder> {
    /**
     * Array of githubUsers.
     */
    private final List<GithubUsers> githubUsers;
    /**
     * Context.
     */
    private final Context context;


    /**
     * Instantiates a new Dev list adapter.
     *
     * @param githubUsers the github users
     * @param context     the context
     */
    public DevListAdapter(List<GithubUsers> githubUsers, Context context) {
        this.githubUsers = githubUsers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_item, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String userName = githubUsers.get(position).getUsername();
        final String userImage = githubUsers.get(position).getUserImage();
        final String githubLink = githubUsers.get(position).getGithubLink();

        holder.textView.setText(userName);

        Glide
                .with(context)
                .load(userImage)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("username", userName);
                intent.putExtra("user image", userImage);
                intent.putExtra("github link", githubLink);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    /**
     * The type View holder.
     */
    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * The Text view.
         */
        TextView textView;
        /**
         * The Image view.
         */
        ImageView imageView;
        /**
         * The Github link.
         */
        TextView githubLink;

        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            githubLink = itemView.findViewById(R.id.githubLink);
        }
    }
}
