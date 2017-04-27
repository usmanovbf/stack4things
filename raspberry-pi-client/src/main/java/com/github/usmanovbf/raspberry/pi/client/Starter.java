package com.github.usmanovbf.raspberry.pi.client;

import com.github.usmanovbf.raspberry.pi.client.sender.RestSender;

import java.util.Timer;
import java.util.TimerTask;

public class Starter {
    public static void main( String[] args ) {
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
