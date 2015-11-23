package com.company.spring_application.mapper;

import com.company.spring_application.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * <p>The MapperJSON class is responsible for converting <b>CSV</b> file received from
 * {@link com.company.spring_application.processor.Processor} class into <b>JSON</b> format and
 * sending the result back to Processor.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class MapperJSON {
    public String convert(Order order) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(order);
    }
}
