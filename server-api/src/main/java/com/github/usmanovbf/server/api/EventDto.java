package com.github.usmanovbf.server.api;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class EventDto implements Serializable {
    private UUID deviceUuid;
    private float temperature;
    private Date createdDate;

    public EventDto( UUID deviceUuid, float temperature, Date createdDate ) {
        this.deviceUuid = deviceUuid;
        this.temperature = temperature;
        this.createdDate = createdDate;
    }

    public EventDto() {
    }

    public UUID getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid( UUID deviceUuid ) {
        this.deviceUuid = deviceUuid;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature( float temperature ) {
        this.temperature = temperature;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate( Date createdDate ) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "deviceUuid=" + deviceUuid +
                ", temperature=" + temperature +
                ", createdDate=" + createdDate +
                '}';
    }
}
