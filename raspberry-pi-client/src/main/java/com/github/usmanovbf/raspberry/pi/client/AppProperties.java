package com.github.usmanovbf.raspberry.pi.client;

import java.util.UUID;

public class AppProperties {
//    private static Properties properties;
//    private static Logger logger = LoggerFactory.getLogger( Collector.class );
//
//    static {
//        InputStream inputStream = AppProperties.class.getResourceAsStream( "app.properties" );
//        try {
//            properties.load( inputStream );
//        } catch (IOException e) {
//            logger.error( "Error while initializing properties file", e );
//        }
//    }

    public static UUID deviceUuid = UUID.fromString( "550e8400-e29b-41d4-a716-446655440000" );

}
