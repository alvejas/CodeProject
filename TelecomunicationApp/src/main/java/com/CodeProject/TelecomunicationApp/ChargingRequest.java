package com.CodeProject.TelecomunicationApp;

import java.time.LocalDateTime;

public class ChargingRequest {

    public ChargingRequest(int requestId, LocalDateTime timeStamp, String service, int msisDN, int rsu) {
        this.requestId = requestId;
        this.timeStamp = timeStamp;
        this.service = service;
        this.msisDN = msisDN;
        this.rsu = rsu;
    }

    private int requestId;
    private LocalDateTime timeStamp;
    private String service;
    private int msisDN;
    private int rsu;


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getMsisDN() {
        return msisDN;
    }

    public void setMsisDN(int msisDN) {
        this.msisDN = msisDN;
    }

    public int getRsu() {
        return rsu;
    }

    public void setRsu(int rsu) {
        this.rsu = rsu;
    }


}
