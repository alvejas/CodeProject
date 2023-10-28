package com.CodeProject.TelecomunicationApp;

public class ChargingReply {
    public ChargingReply(int requestId, String result, int GSU) {
        this.requestId = requestId;
        this.result = result;
        this.GSU = GSU;
    }

    private int requestId;
    private String result;
    private int GSU;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getGSU() {
        return GSU;
    }

    public void setGSU(int GSU) {
        this.GSU = GSU;
    }
}
