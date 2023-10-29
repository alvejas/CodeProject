package com.CodeProject.TelecomunicationApp.Tariffs;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;

import java.time.LocalDateTime;

public class Beta1 implements Tariff{

    private final double priceRoaming = 0.2;
    private final double normalPrice = 0.1;
    private final double priceAtNight = 0.05;

    @Override
    public ChargingReply payment(ChargingRequest request, BillingAccount billing) {

        int rsu = request.getRsu();
        double disccounts = disccounts(billing.getCounterA(), billing.getBucket3());


        if (request.isRoaming()) {
            return getBucketCharged(billing.getBucket3(), disccounts, priceRoaming, rsu, request);
        } else if (!request.isRoaming()) {

            return getBucketCharged(billing.getBucket1(), disccounts, normalPrice, rsu, request);
        } else if (!request.isRoaming() && billing.getCounterB() > 5) {

            return getBucketCharged(billing.getBucket2(), disccounts, normalPrice, rsu, request);
        } else if (!request.isRoaming() && isNight(request.getTimeStamp())) {

            return getBucketCharged(billing.getBucket2(), disccounts, priceAtNight, rsu, request);
        }

        return new ChargingReply(request.getRequestId(), "Unexpected error", 0);

    }

    private double disccounts(int counterA, double bucket3) {
        double discount = 0;

        if (counterA > 10) {
            discount = discount - 0.025;
        }
        if (bucket3 > 50) {
            discount = discount - 0.010;
        }
        return discount;
    }

    private boolean isChargePossible(double cost, double budget, int rsu) {

        double totalCost = rsu * cost;
        if (budget >= totalCost) {
            return true;
        } else {
            return false;
        }


    }

    private double budgetLeft(double cost, double budget, int rsu) {

        double totalCost = rsu * cost;
        return budget - totalCost;

    }

    private ChargingReply getBucketCharged(double bucket, double disccounts, double price, int rsu, ChargingRequest request) {
        double bucketCharged = bucket;
        double totalPrice = price - disccounts;
        int gsu = (int) (bucketCharged / totalPrice);

        if (isChargePossible(totalPrice, bucketCharged, rsu)) {

            budgetLeft(totalPrice, bucketCharged, rsu);
            //TODO Actualizar o BillingAccont

            return new ChargingReply(request.getRequestId(), "Charging completed", rsu);
        } else

            return new ChargingReply(request.getRequestId(), "There is not budget for the transaction", gsu);
    }

    public Boolean isNight(LocalDateTime date) {

        int hour = date.getHour();

        return hour >= 18 || hour < 7;
    }

}
