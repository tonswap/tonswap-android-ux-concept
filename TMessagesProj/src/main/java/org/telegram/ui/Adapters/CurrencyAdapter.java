package org.telegram.ui.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.util.Log;

import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Components.ChatSendMoneyBottomSheet;

import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyView> {

    // List with String type
    private List<ChatSendMoneyBottomSheet.CurrencyItem> list;
    private int colorText;
    public int selectedFrom = 0;
    public int selectedTo = -1;
    private final OnItemClickListener listener;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public class MyView extends RecyclerView.ViewHolder {

        TextView  tvCurrencyHeader;
        TextView  tvCurrencyName;
        ImageView imgViewCurrency;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);

            tvCurrencyHeader = (TextView) view.findViewById(R.id.currency_header);
            tvCurrencyHeader.setTextColor(colorText);
            imgViewCurrency = (ImageView) view.findViewById(R.id.currency_image);
            tvCurrencyName = (TextView) view.findViewById(R.id.currency_name);
            tvCurrencyName.setTextColor(colorText);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public CurrencyAdapter(List<ChatSendMoneyBottomSheet.CurrencyItem> horizontalList, int clrTxt,
                           OnItemClickListener listen)
    {
        this.list = horizontalList;
        this.colorText = clrTxt;
        this.listener = listen;
    }

    public ChatSendMoneyBottomSheet.CurrencyItem getSelectedFromItem(){
        return list.get(selectedFrom);
    }

    public ChatSendMoneyBottomSheet.CurrencyItem getSelectedToItem(){
        if (selectedTo != -1) {
            return list.get(selectedTo);
        }

        return null;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.
    @Override
    public MyView onCreateViewHolder(ViewGroup parent,
                                     int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.crypto_currency_item,
                        parent,false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        if (position == 0){
            holder.tvCurrencyHeader.setText("My Wallet");
        }
        if (position == 4){
            holder.tvCurrencyHeader.setText("Swap to");
        }
        ChatSendMoneyBottomSheet.CurrencyItem item = list.get(position);
        holder.imgViewCurrency.setImageResource(item.imageResId);
        holder.tvCurrencyName.setText(item.currencyName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("oren", "onBindViewHolder- onClick");
                listener.onItemClick(view, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
