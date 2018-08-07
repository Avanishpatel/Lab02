package com.solstice.stockdata.stockdatapersistantquery.controller;

import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public AggregatedData getAggregatedDataByDay(@PathVariable("symbol") String symbol, @PathVariable("date") String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(date);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return stockService.findByNameAndDate(symbol, timestamp);
    }

    @RequestMapping(value = "/{symbol}/month/{month}")
    public AggregatedData getAggregatedDataByMonth(@PathVariable("symbol") String symbol, @PathVariable("month") String month) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(month);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return stockService.findByNameAndMonth(symbol, timestamp);

    }


}
