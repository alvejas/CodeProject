package com.CodeProject.TelecomunicationApp;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CDR")
public class ClientDataRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifier;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getMsisDN() {
        return msisDN;
    }

    public void setMsisDN(int msisDN) {
        this.msisDN = msisDN;
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

    public void setService(String servico) {
        this.service = servico;
    }

    public String getChargingRequest() {
        return chargingRequest;
    }

    public void setChargingRequest(String chargingRequest) {
        this.chargingRequest = chargingRequest;
    }

    public String getChargingReply() {
        return chargingReply;
    }

    public void setChargingReply(String chargingReply) {
        this.chargingReply = chargingReply;
    }

    public int getBucket1() {
        return bucket1;
    }

    public void setBucket1(int bucket1) {
        this.bucket1 = bucket1;
    }

    public int getBucket2() {
        return bucket2;
    }

    public void setBucket2(int bucket2) {
        this.bucket2 = bucket2;
    }

    public int getBucket3() {
        return bucket3;
    }

    public void setBucket3(int bucket3) {
        this.bucket3 = bucket3;
    }

    public int getCounterA() {
        return counterA;
    }

    public void setCounterA(int counterA) {
        this.counterA = counterA;
    }

    public int getCounterB() {
        return counterB;
    }

    public void setCounterB(int counterB) {
        this.counterB = counterB;
    }

    public int getCounterC() {
        return counterC;
    }

    public void setCounterC(int counterC) {
        this.counterC = counterC;
    }

    public int getCounterD() {
        return counterD;
    }

    public void setCounterD(int counterD) {
        this.counterD = counterD;
    }

    private int msisDN;

    private LocalDateTime timeStamp;

    private String service;

    private String chargingRequest;

    private String chargingReply;

    private int bucket1;

    private int bucket2;

    private int bucket3;

    private int counterA;

    private int counterB;

    private int counterC;

    private int counterD;

}
