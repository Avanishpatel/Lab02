package com.solstice.stockdata.stockdatapersistantquery.repository;

import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;


@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {


//    @Query("select new com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData(max(s.price), min(s.price), sum(s.volume)) " +
//            "from Stock s " +
//            "where s.symbol = ?1 " +
//            "and day(s.date) = day(?2)")
//    @Query(value = "select max(s.price), min(s.price), sum(s.volume), price" +
//            "from (" +
//            "       select max(price), min(price),sum(volume) " +
//            "       from Stock " +
//            "       where symbol=:symbol and day(date)=day(:date)" +
//            "   ) as x," +
//            "   (" +
//            "       select price " +
//            "       from Stock " +
//            "       where symbol=:symbol and day(date)=day(:date) ORDER BY date DESC LIMIT 1" +
//            "   ) as y", nativeQuery = true)
    @Query(nativeQuery = true)
    AggregatedData getDataBySymbolAndDay(@Param("symbol") String symbol,@Param("date") Timestamp date);

    @Query(nativeQuery = true)
    AggregatedData getDataBySymbolAndMonth(@Param("symbol") String symbol, @Param("month") String month);
}