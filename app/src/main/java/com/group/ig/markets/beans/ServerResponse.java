package com.group.ig.markets.beans;

import java.util.ArrayList;
import java.util.List;


public class ServerResponse {

    public List<MarketRecord> markets = new ArrayList<>();

    private String chartFormat;
    private String lightstreamerEndpoint;
    private String configuration;

    public ServerResponse() {
    }

    public List<MarketRecord> getMarkets() {
        return markets;
    }

    public void setMarkets(List<MarketRecord> markets) {
        this.markets = markets;
    }

    public String getChartFormat() {
        return chartFormat;
    }

    public void setChartFormat(String chartFormat) {
        this.chartFormat = chartFormat;
    }

    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    public void setLightstreamerEndpoint(String lightstreamerEndpoint) {
        this.lightstreamerEndpoint = lightstreamerEndpoint;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
