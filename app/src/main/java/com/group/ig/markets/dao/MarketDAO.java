package com.group.ig.markets.dao;

import com.google.gson.Gson;
import com.group.ig.markets.Constants;
import com.group.ig.markets.beans.Country;
import com.group.ig.markets.beans.MarketRecord;
import com.group.ig.markets.beans.ServerResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;


public class MarketDAO {

    private static Gson gson = new Gson();

    public static List<MarketRecord> getRecords(Country properties) {
        String url = Constants.urlPrefix
                + properties.getLocale() + "/" + properties.getCountryCode();

        try {
            String json = readUrl(url);
            ServerResponse response = gson.fromJson(json, ServerResponse.class);
            Collections.sort(response.markets);
            return response.markets;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String readUrl(String urlString) throws IOException {
        InputStream is = new URL(urlString).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        } finally {
            is.close();
        }
    }
}
