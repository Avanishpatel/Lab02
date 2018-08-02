package com.solstice.stockdata.stockdatapersistantquery.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class InsertData {

    public void storeDataLocally() throws FileNotFoundException, MalformedURLException {

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new URL("https://bootcamp-training-files.cfapps.io/week2/week2-stocks.json").openStream();
            output = new FileOutputStream("/Users/avanishpatel/Downloads/stock-data-persistant-query/src/main/resources/json/output.json");
            byte[] buffer = new byte[1024];
            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            // Here you could append further stuff to `output` if necessary.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
        }
    }
}
