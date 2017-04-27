package com.github.usmanovbf.raspberry.pi.client.collector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collector {
    private Logger logger = LoggerFactory.getLogger( Collector.class );

    public Collector() {
//        try {
//            PlatformManager.setPlatform( Platform.RASPBERRYPI );
//        } catch (PlatformAlreadyAssignedException e) {
//            logger.error( "Error while setting platform version", e );
//        }
    }
    public float getTemperature() {
        float cpuTemperature = 40;
//        try {
//            cpuTemperature = SystemInfo.getCpuTemperature();
//        } catch (IOException | InterruptedException e) {
//            logger.error( "Error while getting CPU temperature", e );
//        }
        return cpuTemperature;
    }
}
