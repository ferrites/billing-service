package com.examples.microserv.billing.service;

import com.examples.microserv.billing.model.Bill;

import java.util.List;

public interface BillService {
     Bill createBill(Bill bill);
     List<Bill> getBills();

}
