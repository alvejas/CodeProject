package com.CodeProject.TelecomunicationApp.Controller;

import com.CodeProject.TelecomunicationApp.ChargingReply;
import com.CodeProject.TelecomunicationApp.ChargingRequest;
import com.CodeProject.TelecomunicationApp.Services.ChargingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/charge")
public class ChargingController {

    @Autowired
    private final ChargingService chargingService;

    public ChargingController(ChargingService chargingService) {
        this.chargingService = chargingService;
    }

    @PostMapping()
    public ChargingReply SubscribeTariff(@RequestBody ChargingRequest request) {

        if ("A".equals(request.getService())){
            return chargingService.serviceA(request);
        }
        if("B".equals(request.getService())){
            return chargingService.serviceB(request);
        }
        else
            return new ChargingReply(request.getRequestId() , "Invalid Service" , 0 );

    }
}
