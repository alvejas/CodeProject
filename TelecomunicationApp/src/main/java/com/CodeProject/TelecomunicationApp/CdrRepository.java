package com.CodeProject.TelecomunicationApp;

import org.springframework.data.repository.CrudRepository;

public interface CdrRepository extends CrudRepository<ClientDataRecord, Integer> {
}
