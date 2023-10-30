package com.CodeProject.TelecomunicationApp.Tariffs;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;
import com.CodeProject.TelecomunicationApp.Entities.ClientDataRecord;
import com.CodeProject.TelecomunicationApp.Repos.CdrRepository;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class Alpha2 implements Tariff{
    private final double normalPrice = 0.5;
    private final double priceAtNight = 0.25;

    private final com.CodeProject.TelecomunicationApp.Repos.chargingRepository chargingRepository;

    private final com.CodeProject.TelecomunicationApp.Repos.CdrRepository cdrRepository;
    @Autowired
    public Alpha2(com.CodeProject.TelecomunicationApp.Repos.chargingRepository chargingRepository , CdrRepository cdrRepository) {
        this.chargingRepository = chargingRepository;
        this.cdrRepository = cdrRepository;
    }

    @Override
    public ChargingReply payment(ChargingRequest request, BillingAccount billing) {

        int rsu = request.getRsu();
        double disccounts = disccounts(billing.getCounterB(), billing.getBucket2());


        if (!request.isRoaming()) {
            Pair<ChargingReply , Double> pair = getBucketCharged(billing.getBucket2(), disccounts, normalPrice, rsu, request);
            billing.setBucket2(pair.b);
            ClientDataRecord cdr = createCdr(billing , request);
            cdr.setChargingRequest(request.toString());
            cdr.setChargingReply(pair.a.toString());

            chargingRepository.save(billing);
            cdrRepository.save(cdr);
            return pair.a;
        } else if (!request.isRoaming() && isNight(request.getTimeStamp())) {

            Pair<ChargingReply , Double> pair = getBucketCharged(billing.getBucket2(), disccounts, priceAtNight, rsu, request);
            billing.setBucket2(pair.b);
            ClientDataRecord cdr = createCdr(billing , request);
            cdr.setChargingRequest(request.toString());
            cdr.setChargingReply(pair.a.toString());

            chargingRepository.save(billing);
            cdrRepository.save(cdr);
            return pair.a;
        }

        return new ChargingReply(request.getRequestId(), "Unexpected error", 0);

    }

    private double disccounts(int counterB, double bucket2) {
        double discount = 0;

        if (counterB > 10) {
            discount = discount - 0.2;
        }
        if (bucket2 > 15) {
            discount = discount - 0.05;
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

    public Boolean isNight(LocalDateTime date) {

        int hour = date.getHour();

        return hour >= 18 || hour < 7;
    }

    public ClientDataRecord createCdr(BillingAccount billing , ChargingRequest request){
        ClientDataRecord cdr = new ClientDataRecord();
        cdr.setBucket1(billing.getBucket1());
        cdr.setBucket2(billing.getBucket2());
        cdr.setBucket3(billing.getBucket3());
        cdr.setCounterA(billing.getCounterA());
        cdr.setCounterB(billing.getCounterB());
        cdr.setCounterC(billing.getCounterC());
        cdr.setCounterD(billing.getCounterD());
        cdr.setMsisDN(billing.getMsisDN());
        cdr.setService(request.getService());
        cdr.setTimeStamp(request.getTimeStamp());


        return cdr;
    }

}
