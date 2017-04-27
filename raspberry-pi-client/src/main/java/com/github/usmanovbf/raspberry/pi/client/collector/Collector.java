package com.github.usmanovbf.raspberry.pi.client.collector;

import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import com.pi4j.system.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Collector {
    private static Logger logger = LoggerFactory.getLogger( Collector.class );


    static {
        try {
            PlatformManager.setPlatform( Platform.RASPBERRYPI );
        } catch (PlatformAlreadyAssignedException e) {
            logger.error( "Error while setting platform version", e );
        }

    }


    public Collector() {
    }

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
