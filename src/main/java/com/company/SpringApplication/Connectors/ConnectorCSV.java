package com.company.SpringApplication.Connectors;

import com.company.SpringApplication.Processors.Processor;

/**
 * <p>The ConnectorCSV class is responsible for getting date from service in CSV format
 * and then sending it to {@link Processor} for further processing.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class ConnectorCSV {
    /**
     * {@link Processor} class variable. Is used to receive data and reroute it
     * for processing into JSON/XML format and than posting it to DB, Dashboard, Upstream services.
     */
    private Processor processor;

    /**
     * The default class constructor.
     * @param processor Processor variable.
     */
    public ConnectorCSV(Processor processor){
        this.processor = processor;
    }
}