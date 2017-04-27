package com.github.usmanovbf.raspberry.pi.client;

import com.github.usmanovbf.raspberry.pi.client.collector.Collector;
import com.github.usmanovbf.raspberry.pi.client.sender.RestSender;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class Starter {
    private static Logger logger = LoggerFactory.getLogger( Collector.class );

    public static void main( String[] args ) {
        try {
            PlatformManager.setPlatform( Platform.RASPBERRYPI );
        } catch (PlatformAlreadyAssignedException e) {
            logger.error( "Error while setting platform version", e );
        }

        int delay = 5000;   // delay for 5 sec.
        int interval = 1000;  // iterate every sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate( new TimerTask() {
            public void run() {
                new RestSender().send();
            }
        }, delay, interval );
    }
}
