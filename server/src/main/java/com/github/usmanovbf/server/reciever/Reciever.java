package com.github.usmanovbf.server.reciever;

import com.github.usmanovbf.server.api.EventDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/reciever")
public class Reciever {
    @POST
    @Path("/event")
    @Consumes("application/json")
    public Response printMessage( EventDto eventDto ) {
        return Response.status( 200 ).entity( eventDto.toString() ).build();

    }
}
