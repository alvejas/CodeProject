package com.CodeProject.TelecomunicationApp.Repos;

import com.CodeProject.TelecomunicationApp.Entities.ClientDataRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdrRepository extends CrudRepository<ClientDataRecord, Integer> {
}
