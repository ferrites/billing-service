package com.examples.microserv.billing.service;

import com.examples.microserv.billing.model.Services;

import java.util.List;

public interface ServiceService {
    Services createService(Services services);
    List<Services> getServices();
//    List<Services> listSpServiceBySpCode(String SpCode);

}
