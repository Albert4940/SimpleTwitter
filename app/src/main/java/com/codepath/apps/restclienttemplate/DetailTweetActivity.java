package com.codepath.apps.restclienttemplate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailTweetActivity extends AppCompatActivity {

    private ImageView ivProfileImage;
    private TextView tvName;
    private TextView tvScreenName;
    private TextView tvBody;
    private TextView tvTime;
    private RelativeLayout containerD;
    Tweet tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tweet);
        //Toast.makeText(this, "okk", Toast.LENGTH_SHORT).show();
            ivProfileImage=findViewById(R.id.ivProfileImageD);
        tvName=findViewById(R.id.nameD);
           tvScreenName =findViewById(R.id.tvScreenNameD);
           tvBody=findViewById(R.id.tvBodyD);
            tvTime=findViewById(R.id.tvTimesTampD);
          tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
         //Toast.makeText(this,"okk", Toast.LENGTH_SHORT).show();
       // String name = getIntent().getStringExtra("name");
      tvScreenName.setText(tweet.user.screenName);
      tvName.setText(tweet.user.name);
        tvTime.setText(tweet.getFormattedTimestamp(tweet.createdAt));
        tvBody.setText(tweet.body);
        Glide.with(this).load(tweet.user.profileImageUrl).apply(new RequestOptions().transform(new CircleCrop())).into(ivProfileImage);

       // Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImage);
    }
}
