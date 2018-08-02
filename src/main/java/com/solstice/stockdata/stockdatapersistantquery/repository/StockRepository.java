package com.solstice.stockdata.stockdatapersistantquery.repository;

import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StockRepository implements CrudRepository<Stock, String> {

}
