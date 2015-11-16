package com.company.SpringApplication.Processors;

import com.company.SpringApplication.Mappers.MapperJSON;
import com.company.SpringApplication.Mappers.MapperXML;
import com.company.SpringApplication.Publishers.PublisherDashboard;
import com.company.SpringApplication.Publishers.PublisherDatabase;
import com.company.SpringApplication.Publishers.PublisherUpstream;

import java.io.File;

/**
 * <p>The Processor class is responsible for application data routing and management.</p>
 * <p>The main role is to convert data from Connectors package classes using Publishers
 * package classes to appropriate format and then send it to Publishers package classes
 * for further manipulations.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class Processor {
    /**
     * {@link MapperJSON} variable. Is used to convert received files into
     * <b>JSON</b></> format.
     */
    private MapperJSON mapperJSON;

    /**
     * {@link MapperXML} class variable. Is used to convert files into
     * <b>XML</b> format.
     */
    private MapperXML mapperXML;

    /**
     * {@link PublisherDashboard} class variable. Is used to publish data from
     * <b>JSON</b> files in Dashboard.
     */
    private PublisherDashboard publisherDashboard;

    /**
     * {@link PublisherDatabase} class variable. Is used to publish data from
     * <b>XNL</b> files in application database.
     */
    private PublisherDatabase publisherDatabase;

    /**
     * {@link PublisherUpstream} class variable. Is used to publish data from
     * <b>XML</b> files in application database.
     */
    private PublisherUpstream publisherUpstream;

    /**
     * The Default class constructor. It receives links to classes from Publishers package for further
     * usage in data transfer purposes.
     *
     * @param publisherDashboard Reference to {@link PublisherDashboard} class. it connects Processor with
     *                           Dashboard service;
     * @param publisherDatabase Reference to {@link PublisherDatabase} class. It connects Processor with
     *                          Database;
     * @param publisherUpstream Reference to {@link PublisherUpstream} class. It connects Processor with
     *                          Upstream service.
     */
    public Processor(PublisherDashboard publisherDashboard,
                     PublisherDatabase publisherDatabase,
                     PublisherUpstream publisherUpstream){
        this.publisherDashboard = publisherDashboard;
        this.publisherDatabase = publisherDatabase;
        this.publisherUpstream = publisherUpstream;
    }

    /**
     * The Get method for mapperJSON variable. It returns the reference to the current one;
     * @return current mapperJSON value/ref
     */
    public MapperJSON getMapperJSON() {
        return mapperJSON;
    }

    /**
     * The Get method for mapperXML variable. It returns the reference to the current one;
     * @return current mapperXML value/ref
     */
    public MapperXML getMapperXML() {
        return mapperXML;
    }

    /**
     * The Set method for mapperJSON variable. It replaces current with the one in method parameters.
     * @param mapperJSON The value/ref of mapperJSON.
     */
    public void setMapperJSON(MapperJSON mapperJSON) {
        this.mapperJSON = mapperJSON;
    }


    /**
     * The Set method for mapperXML variable. It replaces current with the one in method parameters.
     * @param mapperXML The value/ref of mapperXML.
     */
    public void setMapperXML(MapperXML mapperXML) {
        this.mapperXML = mapperXML;
    }

    public void proccess(File processingFile){};
}
