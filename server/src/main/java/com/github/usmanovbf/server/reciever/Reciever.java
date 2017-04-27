package com.github.usmanovbf.server.reciever;

import com.github.usmanovbf.server.api.EventDto;
import com.github.usmanovbf.server.cep.CepEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/reciever")
public class Reciever {
    private Logger logger = LoggerFactory.getLogger( Reciever.class );

    @POST
    @Path("/event")
    @Consumes("application/json")
    public Response receiveEventDto( EventDto eventDto ) {
        logger.info( "EventDto is received in Reciever.receiveEventDto" );

        CepEngine cepEngine = new CepEngine();
        cepEngine.doWork( eventDto );

        return Response.status( 200 ).entity( eventDto.toString() ).build();

    }
}
