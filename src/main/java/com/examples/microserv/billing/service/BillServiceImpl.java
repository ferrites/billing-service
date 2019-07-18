package com.examples.microserv.billing.service;

import com.examples.microserv.billing.Repository.BillRepository;
import com.examples.microserv.billing.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill createBill(Bill bill) {
        Bill createStatus;
        try {
            createStatus = billRepository.save(bill);

        } catch (Exception e) {
            createStatus = null;
            e.printStackTrace();
        }
        return createStatus;
    }

    @Override
    public List<Bill> getBills() {
        List<Bill> billList;
        try {
            billList = billRepository.findAll();
        } catch (Exception e) {
            billList = null;
        }
        return billList;
    }
}
