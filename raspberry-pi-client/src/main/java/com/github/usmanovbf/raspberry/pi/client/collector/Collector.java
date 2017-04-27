package com.github.usmanovbf.raspberry.pi.client.collector;

import com.pi4j.system.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Collector {
    private Logger logger = LoggerFactory.getLogger( Collector.class );

    public float getTemperature() {
        float cpuTemperature = 40;
        try {
            cpuTemperature = SystemInfo.getCpuTemperature();
        } catch (IOException | InterruptedException e) {
            logger.error( "Error while getting CPU temperature", e );
        }
        return cpuTemperature;
    }
}
