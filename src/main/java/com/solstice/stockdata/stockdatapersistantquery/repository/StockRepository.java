package com.solstice.stockdata.stockdatapersistantquery.repository;

import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {


    @Query("select new com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData(max(s.price), min(s.price), sum(s.volume)) " +
            "from Stock s " +
            "where s.symbol = ?1 " +
            "and day(s.date) = day(?2)")
    AggregatedData getDataBySymbolAndDay(String symbol, Timestamp date);

}
