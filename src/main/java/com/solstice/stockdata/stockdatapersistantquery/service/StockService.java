package com.solstice.stockdata.stockdatapersistantquery.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import com.solstice.stockdata.stockdatapersistantquery.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.io.*;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    public void save(List<Stock> stocks) {

        stocks.forEach(stock -> stockRepository.save(stock));
    }

    public void insertDataToDatabase() {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Stock>> typeReference = new TypeReference<List<Stock>>() {
        };
        try {
            List<Stock> stocks = mapper.readValue(new FileInputStream("/Users/avanishpatel/Downloads/stock-data-persistant-query/src/main/resources/json/output.json"), typeReference);
            this.save(stocks);
            System.out.println("Stock Saved!");
        } catch (IOException e) {
            System.out.println("Unable to save stock: " + e.getMessage());
        }
    }

    public void storeDataLocally(String url) {

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new URL(url).openStream();
            output = new FileOutputStream("/Users/avanishpatel/Downloads/stock-data-persistant-query/src/main/resources/json/output.json");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) try {
                output.close();
            } catch (IOException logOrIgnore) {
            }
            if (input != null) try {
                input.close();
            } catch (IOException logOrIgnore) {
            }
        }

    }


    public AggregatedData findByNameAndDate(String symbol, Timestamp date) {

        return stockRepository.getDataBySymbolAndDay(symbol, date);
    }

    public AggregatedData findByNameAndMonth(String symbol, String month) {

        return stockRepository.getDataBySymbolAndMonth(symbol, month);
    }
}
