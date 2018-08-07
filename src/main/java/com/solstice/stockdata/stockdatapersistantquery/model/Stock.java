package com.solstice.stockdata.stockdatapersistantquery.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_data")
@NamedNativeQueries({
        @NamedNativeQuery(name = "Stock.getDataBySymbolAndDay",
                query = "select *" +
                        " from (" +
                        " select max(price), min(price),sum(volume) " +
                        "        from stock_data " +
                        "        where symbol=:symbol and day(date)=day(:date)) as x," +
                        " ( " +
                        "        select price " +
                        "        from stock_data " +
                        "        where symbol=:symbol and day(date)=day(:date) ORDER BY date DESC LIMIT 1) as y", resultClass = AggregatedData.class, resultSetMapping = "aggregatedData"),

        @NamedNativeQuery(name = "Stock.getDataBySymbolAndMonth",
                query = "select *" +
                        " from (" +
                        " select max(price), min(price),sum(volume) " +
                        "        from stock_data " +
                        "        where symbol=:symbol and month(date)=month(:month)) as x," +
                        " ( " +
                        "        select price " +
                        "        from stock_data " +
                        "        where symbol=:symbol and month(date)=month(:month) ORDER BY date DESC LIMIT 1) as y", resultClass = AggregatedData.class, resultSetMapping = "aggregatedData")
})

@SqlResultSetMapping(
        name = "aggregatedData",
        classes = @ConstructorResult(targetClass = AggregatedData.class,
                columns = {
                        @ColumnResult(name = "max(price)", type = Double.class),
                        @ColumnResult(name = "min(price)", type = Double.class),
                        @ColumnResult(name = "sum(volume)", type = Long.class),
                        @ColumnResult(name = "price", type = Double.class)
                })
)
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

    public Stock() {
    }

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
