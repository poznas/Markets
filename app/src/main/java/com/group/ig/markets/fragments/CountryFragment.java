package com.group.ig.markets.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.group.ig.markets.R;
import com.group.ig.markets.beans.Country;
import com.group.ig.markets.beans.MarketRecord;
import com.group.ig.markets.dao.MarketDAO;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CountryFragment extends Fragment {

    private Country properties;
    private Context context;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.market_recycler)
    RecyclerView marketRecyclerView;
    MarketsAdapter marketsAdapter;

    public void setProperties(Country properties) {
        this.properties = properties;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        ButterKnife.bind(this, view);

        initializeMarketRecycler();
        refreshMarkets();

        return view;
    }

    void refreshMarkets() {
        new Thread(() -> {
            List<MarketRecord> marketRecords = MarketDAO.getRecords(properties);
            if( isAdded() ){
                Activity activity = (Activity) context;
                activity.runOnUiThread(()->{
                    marketsAdapter.replaceRecords(marketRecords);
                    progressBar.setVisibility(View.GONE);
                });
            }
        }).start();
    }

    private void initializeMarketRecycler() {
        marketsAdapter = new MarketsAdapter();
        marketRecyclerView.setAdapter(marketsAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        marketRecyclerView.setLayoutManager(layoutManager);
    }
}
