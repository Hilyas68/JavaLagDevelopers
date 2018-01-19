package com.hcode.javalagdevelopers.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hcode.javalagdevelopers.R;

/**
 * Created by hassan on 11/22/2017.
 */

public class DetailActivity extends AppCompatActivity {
    TextView Link ,  usernameTxt;
    Toolbar toolbar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.image_header);
        usernameTxt = (TextView) findViewById(R.id.username);
        Link = (TextView) findViewById(R.id.link);

        String username = getIntent().getExtras().getString("login");
        String avartarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        Link.setText(link);
        Linkify.addLinks(Link, Linkify.WEB_URLS);

        usernameTxt.setText(username);

        Glide.with(this)
                .load(avartarUrl)
                .placeholder(R.drawable.loading)
                .into(imageView);
         getSupportActionBar().setTitle(username);
    }

    private Intent createShareIntent(){
        String username =  getIntent().getExtras().getString("login");
        String link =  getIntent().getExtras().getString("html_url");
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Checkout this awesome developers @ " + username + ", " + link )
                .getIntent();
        return shareIntent;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareIntent());

        return super.onCreateOptionsMenu(menu);
    }
}
