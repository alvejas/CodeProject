package com.CodeProject.TelecomunicationApp.Repos;

import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingRepository extends CrudRepository<BillingAccount, Integer> {

    BillingAccount findBillingAccountBymsisDN(int msisdn);
}
