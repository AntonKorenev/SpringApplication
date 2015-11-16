package com.company.SpringApplication.Mappers;

import com.company.SpringApplication.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * <p>The MapperJSON class is responsible for converting <b>CSV</b> file received from
 * {@link com.company.SpringApplication.Processors.Processor} class into <b>JSON</b> format and
 * sending the result back to Processor.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class MapperJSON {
    /**
     * The Default class constructor.
     */
    public MapperJSON() {

    }

    public String convert(Order order) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(order);
        return json;
    }
}
