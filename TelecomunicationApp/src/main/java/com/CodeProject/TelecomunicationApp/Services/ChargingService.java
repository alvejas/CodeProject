package com.CodeProject.TelecomunicationApp.Services;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;
import com.CodeProject.TelecomunicationApp.Repos.ChargingRepository;
import com.CodeProject.TelecomunicationApp.Tariffs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class ChargingService {

    @Autowired
    ChargingRepository repo;
    public ChargingReply serviceA(ChargingRequest request){

        BillingAccount billingAccount = repo.findBillingAccountBymsisDN(request.getMsisDN());

        if (isDayOfTheWeek(request.getTimeStamp()) && billingAccount.getCounterA()> 100){
            Alpha1 alpha1 = new Alpha1();
            return alpha1.payment(request , billingAccount);
        }

        if (request.isRoaming() && billingAccount.getBucket2()<10){
            Alpha2 alpha2 = new Alpha2();

            return alpha2.payment(request , billingAccount);
        }

        if (!request.isRoaming() && billingAccount.getBucket2()<10){
            Alpha3 alpha3 = new Alpha3();

            return alpha3.payment(request , billingAccount);
        }

        return new ChargingReply(request.getRequestId() , "There are no Tariffs on Service A that you are eligible for" , 0 );
    }

    public ChargingReply serviceB(ChargingRequest request){
        BillingAccount billingAccount = repo.findBillingAccountBymsisDN(request.getMsisDN());

        if (isNight(request.getTimeStamp())){
            Beta1 beta1 = new Beta1();
            return beta1.payment(request , billingAccount);
        }

        if (request.isRoaming() && billingAccount.getBucket2()<10){
            Beta2 beta2 = new Beta2();

            return beta2.payment(request , billingAccount);
        }

        if (!request.isRoaming() && billingAccount.getBucket3()<10){
            Beta3 beta3 = new Beta3();

            return beta3.payment(request , billingAccount);
        }

        return new ChargingReply(request.getRequestId() , "There are no Tariffs on Service A that you are eligible for" , 0 );
    }

    public Boolean isDayOfTheWeek(LocalDateTime date){

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
    }

    public Boolean isNight(LocalDateTime date){

        int hour = date.getHour();

        return hour >= 18 || hour < 7;
    }
}
