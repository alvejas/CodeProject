package com.CodeProject.TelecomunicationApp.Tariffs;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;
import com.CodeProject.TelecomunicationApp.Repos.ChargingRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Beta3 implements Tariff{

    private final double roamingPrice = 0.1;
    private final double priceAtWeekend =0.025;
    private final com.CodeProject.TelecomunicationApp.Repos.ChargingRepository ChargingRepository;
    @Autowired
    public Beta3(ChargingRepository billingAccountRepository) {
        this.ChargingRepository = billingAccountRepository;
    }
    @Override
    public ChargingReply payment(ChargingRequest request, BillingAccount billing) {

        int rsu = request.getRsu();
        double disccounts = disccounts(billing.getCounterB(), billing.getBucket2());


        if (request.isRoaming()) {
            Pair<ChargingReply , Double> pair = getBucketCharged(billing.getBucket3(), disccounts, roamingPrice, rsu, request);
            billing.setBucket3(pair.b);

            ChargingRepository.save(billing);
        } else if (!request.isRoaming() && isDayOfTheWeek(request.getTimeStamp())) {

            Pair<ChargingReply , Double> pair= getBucketCharged(billing.getBucket3(), disccounts, priceAtWeekend, rsu, request);

            billing.setBucket3(pair.b);

            ChargingRepository.save(billing);
        }

        return new ChargingReply(request.getRequestId(), "Unexpected error", 0);

    }

    private double disccounts(int counterB, double bucket2) {
        double discount = 0;

        if (counterB > 10) {
            discount = discount - 0.02;
        }
        if (bucket2 > 15) {
            discount = discount - 0.005;
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

    private Pair<ChargingReply , Double> getBucketCharged(double bucket, double disccounts, double price, int rsu, ChargingRequest request) {
        double bucketCharged = bucket;
        double totalPrice = price - disccounts;
        int gsu = (int) (bucketCharged / totalPrice);
        double budgetleft;

        if (isChargePossible(totalPrice, bucketCharged, rsu)) {

            budgetleft = bucket - budgetLeft(totalPrice, bucketCharged, rsu);


            return new Pair<>(new ChargingReply(request.getRequestId(), "Charging completed", rsu) , budgetleft );
        } else
            budgetleft = bucket - (gsu * totalPrice);
        return new Pair<> (new ChargingReply(request.getRequestId(), "There is not budget for the transaction", gsu) , budgetleft);
    }

    public Boolean isDayOfTheWeek(LocalDateTime date){

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }
}
