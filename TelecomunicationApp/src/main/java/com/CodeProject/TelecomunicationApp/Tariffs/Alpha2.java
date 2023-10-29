package com.CodeProject.TelecomunicationApp.Tariffs;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;

public class Alpha2 implements Tariff{

    @Override
    public ChargingReply payment(ChargingRequest request, BillingAccount billing) {
        return null;
    }
}
