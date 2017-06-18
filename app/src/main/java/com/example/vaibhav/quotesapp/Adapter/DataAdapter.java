package com.example.vaibhav.quotesapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vaibhav.quotesapp.Model.quote;
import com.example.vaibhav.quotesapp.R;

import java.util.ArrayList;

/**
 * Created by vaibhav on 6/18/17.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<quote> quote;

    public DataAdapter(ArrayList<quote> quote) {
        this.quote = quote;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.quoteText.setText(quote.get(position).getText());
        Log.d("TAGTAG", quote.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return quote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quoteText;
        private ImageView quoteImage;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteText = (TextView) itemView.findViewById(R.id.quote_text);
            quoteImage = (ImageView) itemView.findViewById(R.id.quote_image);
        }
    }
}
