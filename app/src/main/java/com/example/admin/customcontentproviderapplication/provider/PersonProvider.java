package com.example.admin.customcontentproviderapplication.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

//manages access to a structured set of data by handling requests from other applications.
// All methodes except onCreate() must be thread safe.
public class PersonProvider extends ContentProvider {

    private static final String TAG = "PersonProvider";
    private DatabaseHelper dbHelper;
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    // Helps choose what action to take based on incoming URI. Maps content URI "patterns" to
    // integer values. addURI() maps an authority and path to an integer value. The method match()
    // returns the integer value for a URI.
    // *: Matches a string of any valid characters of any length.
    // #: Matches a string of numeric characters of any length.
    // content://<authority>/<path> for tables, and content://<authority>/<path>/<id> for single rows.
    static {
        // for the entire row
        URI_MATCHER.addURI(
                "com.example.admin.customcontentproviderapplication.provider",
                "people",
                1 );
        // for one column
        URI_MATCHER.addURI(
                "com.example.admin.customcontentproviderapplication.provider",
                "people/#",
                2 );
    }

    public PersonProvider() {
    }

    @Override
    public boolean onCreate() {
        // Initialize your provider. The Android system calls this method immediately after it
        // creates your provider. Notice that your provider is not created until a ContentResolver
        // object tries to access it.

        Log.d(TAG, "onCreate: ");
        dbHelper = new DatabaseHelper( getContext() );
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //Retrieve data from your provider. Use the arguments to select the table to query, the rows
        // and columns to return, and the sort order of the result. Return the data as a Cursor object.
        // Should throw an exception on fail.

        Log.d(TAG, "query: ");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();

        switch( URI_MATCHER.match( uri )) {
            case 1:
                // If the incoming URI was for all of the people table
                builder.setTables( dbHelper.TABLE_NAME );
                if (TextUtils.isEmpty(sortOrder))
                    sortOrder = "_ID ASC";
                break;
            case 2:
                // If the incoming URI was for a single row
                builder.setTables( dbHelper.TABLE_NAME );
                // limit query to one row at most:
                builder.appendWhere( " _ID = " + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        Cursor cursor = builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        // Return the MIME type corresponding to a content URI.
        // https://developer.android.com/guide/topics/providers/content-provider-creating.html#MIMETypes

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        // Insert a new row into your provider. Use the arguments to select the destination table
        // and to get the column values to use. Return a content URI for the newly-inserted row.
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s,
                      @Nullable String[] strings) {
        // Update existing rows in your provider.
        return 0;
    }
}

/*
By convention, providers offer access to a single row in a table by accepting a content URI with an
ID value for the row at the end of the URI. Also by convention, providers match the ID value to the
table's _ID column, and perform the requested access against the row that matches.

The app does a query against the provider and displays the resulting Cursor in a ListView using a
CursorAdapter. The definition of CursorAdapter requires one of the columns in the Cursor to be _ID.
 */