package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    private Context context;
    private List<Tweet> tweets;

    // Pass in context and list of tweets


    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // For each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, viewGroup, false);
        return new ViewHolder(view);
    }

    // Bind values based on the position of the element

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Tweet tweet = tweets.get(i);
        viewHolder.tvBody.setText(tweet.body);
        viewHolder.name.setText(tweet.user.name);
        viewHolder.tvScreenName.setText("@"+tweet.user.screenName);
        //Glide.with(context).load(tweet.user.profileImageUrl).into(viewHolder.ivProfileImage);
        Glide.with(context).load(tweet.user.profileImageUrl).apply(new RequestOptions().transform(new CircleCrop())).into(viewHolder.ivProfileImage);
        viewHolder.tvTime.setText(tweet.getFormattedTimestamp(tweet.createdAt));
        //Glide.with(context).load(tweet.media_url).into(viewHolder.ivBody);

        viewHolder.containerD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                Intent i = new Intent(context, DetailTweetActivity.class);
                i.putExtra("tweet", Parcels.wrap(tweet));
                //i.putExtra("name",tweet.user.screenName);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    // Define the ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public ImageView ivBody;
        public TextView name;
        public TextView tvScreenName;
        public TextView tvBody;
        public TextView tvTime;
        public RelativeLayout containerD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage=itemView.findViewById(R.id.ivProfileImage);
            name=itemView.findViewById(R.id.name);
            tvScreenName =itemView.findViewById(R.id.tvScreenName);
            tvBody=itemView.findViewById(R.id.tvBody);
            tvTime=itemView.findViewById(R.id.tvTimesTamp);
            //ivBody =itemView.findViewById(R.id.ivBody);
            containerD = itemView.findViewById(R.id.containerD);
        }
    }


}
