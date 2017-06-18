package com.example.vaibhav.quotesapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaibhav.quotesapp.Model.quote;
import com.example.vaibhav.quotesapp.R;
import com.example.vaibhav.quotesapp.SingleViewActivity;
import com.squareup.picasso.Picasso;

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
    public void onBindViewHolder(final DataAdapter.ViewHolder holder, final int position) {
        holder.quoteText.setText(quote.get(position).getText());
        Picasso.with(holder.quoteImage.getContext()).load(quote.get(position).getImage()).into(holder.quoteImage);
//        Log.d("TAGTAG", quote.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.cardView.getContext(), "clciked" + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(holder.cardView.getContext(), SingleViewActivity.class);
                i.putExtra("text", quote.get(position).getText());
                i.putExtra("img", quote.get(position).getImage());
                holder.cardView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView quoteText;
        private ImageView quoteImage;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteText = (TextView) itemView.findViewById(R.id.quote_text);
            quoteImage = (ImageView) itemView.findViewById(R.id.quote_image);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
