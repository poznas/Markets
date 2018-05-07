package com.group.ig.markets.beans;

public class Country {

    private String displayName;
    private String locale;
    private String countryCode;

    public Country(String displayName, String locale, String countryCode) {
        this.displayName = displayName;
        this.locale = locale;
        this.countryCode = countryCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
