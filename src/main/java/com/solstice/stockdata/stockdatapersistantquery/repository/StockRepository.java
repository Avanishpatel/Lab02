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

    @Query(nativeQuery = true)
    AggregatedData getDataBySymbolAndDay(@Param("symbol") String symbol, @Param("date") Timestamp date);

    @Query(nativeQuery = true)
    AggregatedData getDataBySymbolAndMonth(@Param("symbol") String symbol, @Param("month") Timestamp month);
}