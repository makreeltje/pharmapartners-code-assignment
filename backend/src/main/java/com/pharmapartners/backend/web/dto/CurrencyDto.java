package com.pharmapartners.backend.web.dto;

public class CurrencyDto {
    private Long id;
    private String ticker;
    private String name;
    private Long numberOfCoins;
    private Long marketCap;

    public CurrencyDto() {
    }

    public CurrencyDto(Long id, String ticker, String name, Long numberOfCoins, Long marketCap) {
        this.id = id;
        this.ticker = ticker;
        this.name = name;
        this.numberOfCoins = numberOfCoins;
        this.marketCap = marketCap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
