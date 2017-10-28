package com.example.admin.customcontentproviderapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.customcontentproviderapplication.R;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    private static final String TAG = "MainActivity";
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter();
        presenter.addView(this);
    }
}

/*
X Create a a custom content provider with an underlying SQL database.
X Create any database with at least 5 columns and 10 rows.
X Then retrieve data from that content provider and populate the recyclerView

-Should create two implementation of content provider
-App1: should have the SQL database and the content provider
-App2: should display the content from app1 in a recyclerView via first and second implementation
-Add custom permission to the content provider
-MVP
-Dagger

https://developer.android.com/guide/topics/providers/content-provider-creating.html
 */