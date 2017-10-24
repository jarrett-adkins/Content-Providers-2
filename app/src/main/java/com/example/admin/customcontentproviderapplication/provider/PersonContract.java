package com.example.admin.customcontentproviderapplication.provider;

import android.net.Uri;
import android.provider.BaseColumns;

// a class that contains constant definitions for the URIs, column names, MIME types, and other
// meta-data that pertain to the provider.
public final class PersonContract {

    // the symbolic name of the entire provider. The Android-internal name. You can define your
    // provider authority as an extension of the name of the package containing the provider.
    public static final String AUTHORITY = "com.example.admin.customcontentproviderapplication.provider.";

    // A URI that identifies data in a provider. Includes the authority and a name that points to a
    // table or file (a path). Every data access method of ContentProvider has a content URI as an
    // argument; this allows you to determine the table, row, or file to access. The ContentProvider
    // uses the path part of the content URI to choose the table to access. A provider usually has a
    // path for each table it exposes.
    //
    // content://user_dictionary/words
    // user_dictionary is the provider's authority, words is the table's path. content://  is always
    // present, and identifies this as a content URI.
    //
    // Developers usually create content URIs from the authority by appending paths that point to
    // individual tables.
    // com.example.<appname>.provider/table1
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    //The name of the primary column. The developer site recommends using this because linking the
    // results of a provider query to a ListView requires one of the retrieved columns to have the
    // name _ID.
    public static final String SELECTION_ID_BASED = BaseColumns._ID;
}

/*
Define the provider's authority string, its content URIs, and column names. If you want the
provider's application to handle intents, also define intent actions, extras data, and flags. Also
define the permissions that you will require for applications that want to access your data.
 */
