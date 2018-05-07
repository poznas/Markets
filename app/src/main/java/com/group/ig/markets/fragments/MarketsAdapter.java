package com.group.ig.markets.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.group.ig.markets.R;
import com.group.ig.markets.beans.MarketRecord;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MarketsAdapter extends RecyclerView.Adapter<MarketsAdapter.MarketViewHolder>{

    private List<MarketRecord> records = new ArrayList<>();

    public MarketsAdapter() {
    }

    public void replaceRecords(List<MarketRecord> marketRecords){
        if(marketRecords != null ){
            records.clear();
            records.addAll(marketRecords);
            notifyDataSetChanged();
        }
    }

    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_market, parent, false);

        return new MarketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MarketViewHolder holder, int position) {
        MarketRecord currentRecord = records.get(position);

        holder.setMarketData(currentRecord);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.inst_name_view)
        TextView instrumentNameView;
        @BindView(R.id.display_offer_view)
        TextView displayOfferView;

        public MarketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setMarketData(MarketRecord currentRecord) {
            instrumentNameView.setText(currentRecord.getInstrumentName());
            displayOfferView.setText(currentRecord.getDisplayOffer());
        }
    }
}
