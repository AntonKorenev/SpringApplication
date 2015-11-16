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

    //Until tomorrow the response String is static. Than it will be replaced by the servlet response.
    private Order getOrderFromService(){
        String csvString = "-1,Anton,Korenev,Intern,He wants to learn spring";
        String[] values = csvString.split(",");
        return new Order(Integer.valueOf(values[0]),values[1],values[2],values[3],values[4]);
    }

    public void sendOrderForProcessing(){
        //not sure how is this code block correlated with Spring app logic(Specifically, putting createFile() to
        // process(File f)).
        try {
            processor.proccess(getOrderFromService());
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}