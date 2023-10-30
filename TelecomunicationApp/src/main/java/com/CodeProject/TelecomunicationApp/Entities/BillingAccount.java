package com.CodeProject.TelecomunicationApp.Entities;


import jakarta.persistence.*;

@Entity(name = "billing")
public class BillingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identifier;
    private int msisDN;

    private double bucket1;

    private double bucket2;

    private double bucket3;

    private int counterA;

    private int counterB;

    private int counterC;

    private int counterD;

    public String getMobilePlanA() {
        return mobilePlanA;
    }

    public void setMobilePlanA(String mobilePlanA) {
        this.mobilePlanA = mobilePlanA;
    }

    public String getMobilePlanB() {
        return mobilePlanB;
    }

    public void setMobilePlanB(String mobilePlanB) {
        this.mobilePlanB = mobilePlanB;
    }

    private String mobilePlanA;

    private String mobilePlanB;

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


    public double getBucket1() {
        return bucket1;
    }

    public void setBucket1(double bucket1) {
        this.bucket1 = bucket1;
    }

    public double getBucket2() {
        return bucket2;
    }

    public void setBucket2(double bucket2) {
        this.bucket2 = bucket2;
    }

    public double getBucket3() {
        return bucket3;
    }

    public void setBucket3(double bucket3) {
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
}
