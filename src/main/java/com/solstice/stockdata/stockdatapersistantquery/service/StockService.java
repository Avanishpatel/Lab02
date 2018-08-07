package com.solstice.stockdata.stockdatapersistantquery.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import com.solstice.stockdata.stockdatapersistantquery.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public void save(List<Stock> stocks) {

        stockRepository.saveAll(stocks);
    }

    public void insertDataToDatabase() {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Stock>> typeReference = new TypeReference<List<Stock>>() {
        };
        try {
            List<Stock> stocks = mapper.readValue(new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json"), typeReference);
            this.save(stocks);
            System.out.println("Stock Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save stock: " + e.getMessage());
        }
    }

    public AggregatedData findByNameAndDate(String symbol, Timestamp date) {

        return stockRepository.getDataBySymbolAndDay(symbol, date);
    }

    public AggregatedData findByNameAndMonth(String symbol, Timestamp month) {

        return stockRepository.getDataBySymbolAndMonth(symbol, month);
    }
}
