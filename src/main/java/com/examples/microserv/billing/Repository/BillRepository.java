package com.examples.microserv.billing.Repository;

import com.examples.microserv.billing.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Bill,String> {
}
