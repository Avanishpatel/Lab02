package com.solstice.stockdata.stockdatapersistantquery.controller;

import com.solstice.stockdata.stockdatapersistantquery.model.AggregatedData;
import com.solstice.stockdata.stockdatapersistantquery.model.Stock;
import com.solstice.stockdata.stockdatapersistantquery.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String stockIndex(){
        return "Welcome to Stock Application";
    }


    @RequestMapping(value ="/saveData", method = RequestMethod.GET)
    public String saveDataLocally() {

        stockService.storeDataLocally();

        return "Data saved successfully";
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public String saveAllToDatabase() {

        stockService.insertDataToDatabase();

        return "Data inserted into database";
    }

    @RequestMapping(value = "/{symbol}/{date}", method = RequestMethod.GET)
    public AggregatedData getAggregatedData(@PathVariable("symbol") String symbol, @PathVariable("date") String date) throws ParseException {

        //String date1 = date + " 03:30:00";
//        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Timestamp timestamp = Timestamp.valueOf(String.format(date, df2));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = dateFormat.parse(date);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

        return stockService.findByNameAndDate(symbol, timestamp);
    }


}
