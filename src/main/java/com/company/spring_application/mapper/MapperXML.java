package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import com.thoughtworks.xstream.XStream;

/**
 * <p>The MapperXML class is responsible for converting <b>CSV</b> file received from
 * {@link com.company.spring_application.processor.Processor} class into <b>XML</b> format and
 * sending the result back to Processor.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class MapperXML {
    public String convert(Order order){
        XStream xs = new XStream();
        String xml = xs.toXML(order);
        return xml;
    }
}