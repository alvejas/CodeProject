package com.CodeProject.TelecomunicationApp;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ChargingRepository extends CrudRepository<BillingAccount, Integer> {


}
