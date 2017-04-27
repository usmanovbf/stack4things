package com.github.usmanovbf.server.sender;

import com.github.usmanovbf.server.api.EventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sender {
    private Logger logger = LoggerFactory.getLogger( Sender.class );

    public void acceptEvent( EventDto eventDto ) {
        logger.info( eventDto.toString() );
    }
}
