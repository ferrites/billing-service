package com.examples.microserv.billing.service;

import com.examples.microserv.billing.Repository.ServiceRepository;
import com.examples.microserv.billing.model.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public Services createService(Services services) {
        Services createStatus;
        try {
            createStatus = serviceRepository.save(services);

        } catch (Exception e) {
            createStatus = null;
            e.printStackTrace();
        }
        return createStatus;
    }
    @Override
    public List<Services> getServices() {
        List<Services> servicesList;
        try {
            servicesList = serviceRepository.findAll();
        } catch (Exception e) {
            servicesList = null;
        }
        return servicesList;
    }

//    @Override
//    public List<Services> listSpServiceBySpCode(String SpCode) {
//        List<Services> servicesList;
//        try {
//            servicesList = serviceRepository.findServicesBySpCode(SpCode);
//        } catch (Exception e) {
//            servicesList = null;
//        }
//        return servicesList;
//    }
}
