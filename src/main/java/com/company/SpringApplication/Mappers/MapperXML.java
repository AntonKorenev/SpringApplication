package com.company.SpringApplication.Mappers;

import com.company.SpringApplication.domain.Order;
import com.thoughtworks.xstream.XStream;

/**
 * <p>The MapperXML class is responsible for converting <b>CSV</b> file received from
 * {@link com.company.SpringApplication.Processors.Processor} class into <b>XML</b> format and
 * sending the result back to Processor.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class MapperXML {
    /**
     * The Default class constructor.
     */
    public MapperXML() {

    }

    public String convert(Order order){
        XStream xs = new XStream();
        String xml = xs.toXML(order);
        System.out.println(xml);
        return xml;
    }
}