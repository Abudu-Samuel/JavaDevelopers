package com.andela.javadevelopers.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.javadevelopers.R;
import com.andela.javadevelopers.contract.MainContract;
import com.andela.javadevelopers.home.model.GithubUsers;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * The type Dev list adapter.
 */
public class DevListAdapter extends RecyclerView.Adapter<DevListAdapter.ViewHolder> {
    /**
     * Array of githubUsers.
     */
    private final List<GithubUsers> githubUsers;
    /**
     * MainContract.RecyclerItemClickListener.
     */
    MainContract.RecyclerItemClickListener recyclerItemClickListener;

    /**
     * Instantiates a new Dev list adapter.
     *
     * @param githubUsers               the github users
     * @param recyclerItemClickListener the recycler item click listener
     */
    public DevListAdapter(List<GithubUsers> githubUsers,
                          MainContract.RecyclerItemClickListener recyclerItemClickListener) {
        this.githubUsers = githubUsers;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card_item, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String userName = githubUsers.get(position).getUsername();
        final String userImage = githubUsers.get(position).getUserImage();

        holder.textView.setText(userName);

        Glide
                .with(holder.itemView.getContext())
                .load(userImage)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerItemClickListener.onItemClick(githubUsers.get(holder.getAdapterPosition()));
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
        @BindView(R.id.textView) TextView textView;
        /**
         * The Image view.
         */
        @BindView(R.id.imageView) ImageView imageView;
        /**
         * Instantiates a new View holder.
         *
         * @param itemView the item view
         */
        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
