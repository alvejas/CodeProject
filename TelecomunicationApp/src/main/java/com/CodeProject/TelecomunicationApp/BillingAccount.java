package com.CodeProject.TelecomunicationApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BillingAccount {

    @Id
    private int identifier;
    private int msisDN;

    private int bucket1;

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    private int bucket2;

    private int bucket3;

    private int counterA;

    private int counterB;

    private int counterC;

    private int counterD;

    private String tarifarioServicoA;

    private String tarifarioServicoB;

    public int getMsisDN() {
        return msisDN;
    }

    public void setMsisDN(int msisDN) {
        this.msisDN = msisDN;
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

    public String getTarifarioServicoA() {
        return tarifarioServicoA;
    }

    public void setTarifarioServicoA(String tarifarioServicoA) {
        this.tarifarioServicoA = tarifarioServicoA;
    }

    public String getTarifarioServicoB() {
        return tarifarioServicoB;
    }

    public void setTarifarioServicoB(String tarifarioServicoB) {
        this.tarifarioServicoB = tarifarioServicoB;
    }


}
