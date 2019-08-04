package com.codepath.apps.restclienttemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComposeActivity extends AppCompatActivity {

    private EditText etCompose;
    private Button btnTweet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        //set click listener on button
        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String tweetContent = etCompose.getText().toString();

                //error-handling
                if(tweetContent.isEmpty())
                {
                    Toast.makeText(ComposeActivity.this, "Your tweet is empty !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(tweetContent.length()>140)
                {
                    Toast.makeText(ComposeActivity.this, "Your tweet is lonnger !", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(ComposeActivity.this, tweetContent, Toast.LENGTH_LONG).show();
                //Make API to call to twitter to publish
            }
        });


    }
}
