package com.pharmapartners.backend.web.model;

public class CurrencyRequestModel {

    private String ticker;
    private String name;
    private Long numberOfCoins;
    private Long marketCap;

    public CurrencyRequestModel() {
    }

    public CurrencyRequestModel(String ticker, String name, Long numberOfCoins, Long marketCap) {
        this.ticker = ticker;
        this.name = name;
        this.numberOfCoins = numberOfCoins;
        this.marketCap = marketCap;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(Long numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }
}
