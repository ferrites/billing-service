package com.examples.microserv.billing.Repository;

import com.examples.microserv.billing.model.Services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends MongoRepository<Services,String> {
//    @Query("select * from Service where spCode = :spCode")
//    List<Services> findServicesBySpCode(@Param("spCode") String spCode);
}
