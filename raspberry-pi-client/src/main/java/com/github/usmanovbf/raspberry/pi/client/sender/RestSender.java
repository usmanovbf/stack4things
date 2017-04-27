package com.github.usmanovbf.raspberry.pi.client.sender;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.usmanovbf.raspberry.pi.client.AppProperties;
import com.github.usmanovbf.raspberry.pi.client.collector.Collector;
import com.github.usmanovbf.server.api.EventDto;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

public class RestSender {
    private Logger logger = LoggerFactory.getLogger( RestSender.class );

    public void send() {
        logger.info( "RestSender.send started" );

//        Client client = ClientBuilder.newClient();
//        logger.info( "RestSender.send.client created" );
//
//        WebTarget target = client.target( "http://localhost:8080/server/rest/reciever/event" );
//        logger.info( "RestSender.send.target created" );
//
//        EventDto eventDto = collectEvent();
//        logger.info( "RestSender.send.eventDto created: " + eventDto.toString() );
//
//        Response response = target.request().post( Entity.entity( eventDto, MediaType.APPLICATION_JSON ) );
//        logger.info( "RestSender.send.response created" );
//
//        response.close();
//        logger.info( "RestSender.send.response closed" );

        try {

            ClientRequest request = new ClientRequest(
                    "http://localhost:8080/server/rest/reciever/event" );
            request.accept( "application/json" );
            logger.info( "RestSender.request created" );

            ObjectMapper mapper = new ObjectMapper();
            EventDto eventDto = collectEvent();
            logger.info( "RestSender.send.eventDto created: " + eventDto.toString() );

            String input = mapper.writeValueAsString( eventDto );
            logger.info( "RestSender.send.input created: " + input );

            request.body( "application/json", input );

            ClientResponse<String> response = request.post( String.class );

            if (response.getStatus() != 201) {
                throw new RuntimeException( "Failed : HTTP error code : "
                        + response.getStatus() );
            }

            BufferedReader br = new BufferedReader( new InputStreamReader(
                    new ByteArrayInputStream( response.getEntity().getBytes() ) ) );

            String output;
            logger.info( "Output from Server .... \n" );
            while (( output = br.readLine() ) != null) {

                logger.info( output );
            }

        } catch (Exception e) {

            logger.error( "Error", e );

        }
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
