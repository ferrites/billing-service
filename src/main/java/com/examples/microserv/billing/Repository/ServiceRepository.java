package com.examples.microserv.billing.Repository;

import com.examples.microserv.billing.model.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Service,String> {

}
