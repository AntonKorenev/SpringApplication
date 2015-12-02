package com.company.spring_application.processor;

import com.company.spring_application.mapper.MapperJSON;
import com.company.spring_application.mapper.MapperXML;
import com.company.spring_application.publisher.PublisherDashboard;
import com.company.spring_application.publisher.PublisherDatabase;
import com.company.spring_application.publisher.PublisherUpstream;
import com.company.spring_application.domain.Order;

/**
 * <p>The Processor class is responsible for application data routing and management.</p>
 * <p>The main role is to convert data from connector package classes using publisher
 * package classes to appropriate format and then send it to publisher package classes
 * for further manipulations.</p>
 *
 * @author AntonKorenev
 * @version 0.1
 */
public class Processor {
    private MapperJSON mapperJSON;
    private MapperXML mapperXML;
    private PublisherDashboard publisherDashboard;
    private PublisherDatabase publisherDatabase;
    private PublisherUpstream publisherUpstream;

    public Processor(PublisherDashboard publisherDashboard,
                     PublisherDatabase publisherDatabase,
                     PublisherUpstream publisherUpstream) {
        this.publisherDashboard = publisherDashboard;
        this.publisherDatabase = publisherDatabase;
        this.publisherUpstream = publisherUpstream;
    }

    public MapperJSON getMapperJSON() {
        return mapperJSON;
    }

    public MapperXML getMapperXML() {
        return mapperXML;
    }

    public void setMapperJSON(MapperJSON mapperJSON) {
        this.mapperJSON = mapperJSON;
    }

    public void setMapperXML(MapperXML mapperXML) {
        this.mapperXML = mapperXML;
    }

    public void proccess(Order processingOrder) {

    }
}
