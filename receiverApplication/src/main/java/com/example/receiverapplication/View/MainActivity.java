package com.example.receiverapplication.View;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.receiverapplication.R;
import com.example.receiverapplication.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    MyItemListAdapter myItemListAdapter;
    List<Person> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById( R.id.rvPersonList );
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(itemAnimator);

        Uri contentURI = Uri.parse("content://com.example.admin.customcontentproviderapplication.provider/people");

        Cursor cursor = getContentResolver().query(
                contentURI, null, null, null, null);

        while(cursor.moveToNext()){
            items.add( new Person(
                    cursor.getString( 1 ),
                    cursor.getString( 2 ),
                    cursor.getInt( 3 ),
                    cursor.getString( 4 ),
                    cursor.getInt( 5 )
            ));
        }

        myItemListAdapter = new MyItemListAdapter( items );
        recyclerView.setAdapter( myItemListAdapter );
    }
}
