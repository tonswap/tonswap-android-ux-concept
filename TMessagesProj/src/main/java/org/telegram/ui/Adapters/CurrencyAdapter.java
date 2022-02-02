package org.telegram.ui.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.telegram.messenger.R;

import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyView> {

    // List with String type
    private List<Integer> list;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class MyView extends RecyclerView.ViewHolder {

        ImageView imgViewCurrency;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            // initialise TextView with id
            imgViewCurrency = (ImageView) view.findViewById(R.id.currency_image);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public CurrencyAdapter(List<Integer> horizontalList)
    {
        this.list = horizontalList;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {

        // Inflate item.xml using LayoutInflator
        View itemView
                = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.crypto_currency_item,
                        parent,
                        false);

        // return itemView
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.imgViewCurrency.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
