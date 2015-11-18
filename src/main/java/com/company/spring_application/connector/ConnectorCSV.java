package com.company.spring_application.connector;

import com.company.spring_application.processor.Processor;
import com.company.spring_application.domain.Order;

/**
 * <p>The ConnectorCSV class is responsible for getting date from service in CSV format
 * and then sending it to {@link Processor} for further processing.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class ConnectorCSV {
    private Processor processor;

    public ConnectorCSV(Processor processor){
        this.processor = processor;
    }

    private Order formOrderFromCSV(String csvString){
        String[] values = csvString.split(",");
        return new Order(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4]);
    }

    public void sendForProcessing(String csvString){
        try {
            processor.proccess(formOrderFromCSV(csvString));
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}