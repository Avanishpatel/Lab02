package com.solstice.stockdata.stockdatapersistantquery.model;

import java.math.BigDecimal;

public class StockSummary {
    private String symbol;
    private BigDecimal open_price;
    private BigDecimal low_price;
    private BigDecimal high_price;
    private BigDecimal closing_price;
    private Integer volume;


    public StockSummary() {
    }

    public StockSummary(String symbol, BigDecimal open_price, BigDecimal low_price, BigDecimal high_price, BigDecimal closing_price, Integer volume) {
        this.symbol = symbol;
        this.open_price = open_price;
        this.low_price = low_price;
        this.high_price = high_price;
        this.closing_price = closing_price;
        this.volume = volume;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getOpen_price() {
        return open_price;
    }

    public void setOpen_price(BigDecimal open_price) {
        this.open_price = open_price;
    }

    public BigDecimal getLow_price() {
        return low_price;
    }

    public void setLow_price(BigDecimal low_price) {
        this.low_price = low_price;
    }

    public BigDecimal getHigh_price() {
        return high_price;
    }

    public void setHigh_price(BigDecimal high_price) {
        this.high_price = high_price;
    }

    public BigDecimal getClosing_price() {
        return closing_price;
    }

    public void setClosing_price(BigDecimal closing_price) {
        this.closing_price = closing_price;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
