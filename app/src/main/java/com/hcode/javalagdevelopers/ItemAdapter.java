package com.hcode.javalagdevelopers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hcode.javalagdevelopers.controller.DetailActivity;
import com.hcode.javalagdevelopers.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by hassan on 11/22/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getLogin());
        holder.gitHubLink.setText(items.get(position).getHtmlUrl());

        Picasso.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.loading)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, gitHubLink;
        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            title  = (TextView) itemView.findViewById(R.id.title);
            gitHubLink = (TextView) itemView.findViewById(R.id.githubLink);
            imageView = (ImageView) itemView.findViewById(R.id.cover);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Item clikedItem =  items.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", items.get(position).getLogin());
                        intent.putExtra("html_url", items.get(position).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(position).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(), "You clicked " + clikedItem.getLogin(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
