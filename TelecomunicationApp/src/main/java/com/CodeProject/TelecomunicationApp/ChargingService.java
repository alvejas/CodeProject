package com.CodeProject.TelecomunicationApp;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargingService {

    @Autowired
    ChargingRepository repo;
    public ChargingReply serviceA(ChargingRequest request){
        return null;
    }

    public ChargingReply serviceB(ChargingRequest request){
        return null;
    }
}
