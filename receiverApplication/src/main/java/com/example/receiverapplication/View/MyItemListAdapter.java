package com.example.receiverapplication.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.receiverapplication.R;
import com.example.receiverapplication.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MyItemListAdapter extends RecyclerView.Adapter<MyItemListAdapter.ViewHolder> {

    private static final String TAG = "MyItemListAdapter";
    Context context;
    List<Person> items = new ArrayList<>();

    public MyItemListAdapter(List<Person> itemList) {
        this.items = itemList;
    }

    @Override
    public MyItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater
                .from( parent.getContext() )
                .inflate( R.layout.list_item, parent, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(MyItemListAdapter.ViewHolder holder, final int position) {
        Person p = items.get( position );

        holder.firstName.setText( p.getFirstName() );
        holder.lastName.setText( p.getLastName() );
        holder.age.setText( String.valueOf( p.getAge() ));
        holder.address.setText( p.getAddress() );
        holder.ssn.setText( String.valueOf( p.getSsn() ));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName, age, address, ssn;

        public ViewHolder(View itemView) {
            super(itemView);

            firstName = itemView.findViewById( R.id.tvFirstName );
            lastName = itemView.findViewById( R.id.tvLastName );
            age = itemView.findViewById( R.id.tvAge );
            address = itemView.findViewById( R.id.tvAddress );
            ssn = itemView.findViewById( R.id.tvSSN );
        }
    }
}
