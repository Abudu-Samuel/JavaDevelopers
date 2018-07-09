package com.andela.javadevelopers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.andela.javadevelopers.ListItem;
import com.andela.javadevelopers.R;
import com.andela.javadevelopers.view.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;


/**
 * The type Dev list adapter.
 */
public class DevListAdapter extends RecyclerView.Adapter<DevListAdapter.ViewHolder> {
    /**
     * Array of listItems.
     */
    private final List<ListItem> listItems;
    /**
     * Context.
     */
    private final Context context;

    /**
     * Instantiates a new Dev list adapter.
     *
     * @param listItems the list items
     * @param context   the context
     */
    public DevListAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
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
        final ListItem listItem = listItems.get(position);
        final String userName = listItems.get(position).getUsername();
        final String userImage = listItems.get(position).getImage();
        final String githubLink = listItems.get(position).getGithubLink();

        holder.textView.setText(listItem.getUsername());

        Glide
                .with(context)
                .load(listItem.getImage())
                .apply(new RequestOptions()
                        .placeholder(R.drawable.image_placeholder)
                )
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("USER_IMAGE", userImage);
                intent.putExtra("GITHUB_LINK", githubLink);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
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
