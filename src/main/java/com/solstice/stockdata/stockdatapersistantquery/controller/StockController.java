package com.solstice.stockdata.stockdatapersistantquery.controller;

import com.solstice.stockdata.stockdatapersistantquery.service.InsertData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Controller
public class StockController {

    @Autowired
    InsertData insertData;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value ="/saveData", method = RequestMethod.GET)
    public String saveDataLocally(Model model) {

        try {
            insertData.storeDataLocally();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        model.addAttribute("message", "Data saved locally.");

        return "index";
    }


}
