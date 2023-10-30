package com.CodeProject.TelecomunicationApp.Repos;

import com.CodeProject.TelecomunicationApp.Entities.BillingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chargingRepository extends CrudRepository<BillingAccount, Integer> {

    BillingAccount findBillingAccountBymsisDN(int msisdn);
}
