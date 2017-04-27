package com.github.usmanovbf.raspberry.pi.client.sender;


import com.github.usmanovbf.raspberry.pi.client.AppProperties;
import com.github.usmanovbf.raspberry.pi.client.collector.Collector;
import com.github.usmanovbf.server.api.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;

public class RestSender {
    private Logger logger = LoggerFactory.getLogger( RestSender.class );

    public void send() {
        logger.info( "RestSender.send started" );

        Client client = ClientBuilder.newClient();
        logger.info( "RestSender.send.client created" );

        WebTarget target = client.target( "http://localhost:8080/server/rest/reciever/event" );
        logger.info( "RestSender.send.target created" );

        EventDto eventDto = collectEvent();
        logger.info( "RestSender.send.eventDto created: " + eventDto.toString() );

        Response response = target.request().post( Entity.entity( eventDto, MediaType.APPLICATION_JSON_TYPE ) );
        logger.info( "RestSender.send.response created" );

        response.close();
        logger.info( "RestSender.send.response closed" );

    }

    private EventDto collectEvent() {
        EventDto eventDto = new EventDto();
        Collector collector = new Collector();
        float temperature = collector.getTemperature();

        eventDto.setDeviceUuid( AppProperties.deviceUuid );
        eventDto.setTemperature( temperature );

        Date createdDate = Calendar.getInstance().getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
//        String createdDate = dateFormat.( calendarDate );
        eventDto.setCreatedDate( createdDate );
        return eventDto;
    }

}
