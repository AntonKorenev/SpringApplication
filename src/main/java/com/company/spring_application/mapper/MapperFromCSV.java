package com.company.spring_application.mapper;

import com.company.spring_application.domain.Client;
import com.company.spring_application.domain.Product;
import com.company.spring_application.processor.Processor;
import com.company.spring_application.domain.Order;

/**
 * <p>The MapperFromCSV class is responsible for getting date from service in CSV format
 * and then sending it to {@link Processor} for further processing.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class MapperFromCSV {
    private Processor processor;

    public MapperFromCSV(Processor processor){
        this.processor = processor;
    }

    private Order formOrderFromCSV(String csvString) throws NullPointerException{
       String[] orderAndProductsString = csvString.split("\n");
       String[] os = orderAndProductsString[0].split(",");
       Product[] products = new Product[orderAndProductsString.length-1];
        for(int i=1; i<orderAndProductsString.length; i++){
           String[] ps = orderAndProductsString[i].split(",");
           products[i-1] = new Product(Integer.valueOf(ps[0]),Double.valueOf(ps[1]),ps[2]);
       }
       return new Order(Integer.valueOf(os[0]), new Client(os[1],os[2]), os[3], products);
    }

    public void sendForProcessing(String csvString){
        try {
            processor.proccess(formOrderFromCSV(csvString));
        } catch (NullPointerException ex){
            ex.printStackTrace();
        }
    }
}