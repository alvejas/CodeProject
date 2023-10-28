package com.CodeProject.TelecomunicationApp;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargingService {

    @Autowired
    ChargingRepository repo;

}
