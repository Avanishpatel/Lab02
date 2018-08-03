package com.solstice.stockdata.stockdatapersistantquery.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_data")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "price")
    private Double price;
    @Column(name = "volume")
    private int volume;
    @Column(name = "date")
    private Date date;

    public Stock(){}

    public Stock(String symbol, Double price, int volume, Date date) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
