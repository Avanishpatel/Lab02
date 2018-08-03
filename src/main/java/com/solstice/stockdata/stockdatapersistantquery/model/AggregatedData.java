package com.solstice.stockdata.stockdatapersistantquery.model;


import java.io.Serializable;

public class AggregatedData implements Serializable {

    private double highestPrice;
    private double lowestPrice;
    private long totalTrade;

    public AggregatedData(){}

    public AggregatedData(double highestPrice, double lowestPrice, long totalTrade) {
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.totalTrade = totalTrade;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public long getTotalTrade() {
        return totalTrade;
    }

    public void setTotalTrade(long totalTrade) {
        this.totalTrade = totalTrade;
    }
}
