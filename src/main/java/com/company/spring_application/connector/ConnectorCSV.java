package com.company.spring_application.connector;

import com.company.spring_application.domain.Product;
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

    private Order formOrderFromCSV(String csvString) throws NullPointerException{
        String[] orderValues = csvString.split(",");
        Product[] productsInOrder = new Product[orderValues.length - 4];
        if(orderValues.length < 4){
            throw new NullPointerException("Empty product list");
        } else{
            for(int i = 4; i < orderValues.length; i++){
                String[] productSplit = orderValues[i].split(" ");
                productsInOrder[i-4] = new Product(Integer.valueOf(productSplit[0]), Double.valueOf(productSplit[1]),
                        productSplit[2]);
            }
        }
        return new Order(Integer.valueOf(orderValues[0]), orderValues[1], orderValues[2], orderValues[3],
                productsInOrder);
    }

    public void sendForProcessing(String csvString){
        try {
            processor.proccess(formOrderFromCSV(csvString));
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}