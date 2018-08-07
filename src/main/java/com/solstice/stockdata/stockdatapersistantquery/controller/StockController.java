package com.solstice.stockdata.stockdatapersistantquery.controller;

import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String stockIndex() {
        return "Welcome to Stock Application";
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public String saveAllToDatabase() {

        stockService.insertDataToDatabase();
        return "Data inserted into database";
    }

    @RequestMapping(value = "/{symbol}/{date}", method = RequestMethod.GET)
    public AggregatedData getAggregatedDataByDay(@PathVariable("symbol") String symbol, @PathVariable("date") String date) {

        return stockService.findByNameAndDate(symbol, date);
    }

    @RequestMapping(value = "/{symbol}/month/{month}")
    public AggregatedData getAggregatedDataByMonth(@PathVariable("symbol") String symbol, @PathVariable("month") String month) {

        return stockService.findByNameAndMonth(symbol, month);
    }


}
