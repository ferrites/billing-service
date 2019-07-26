package com.examples.microserv.billing.service;

import com.examples.microserv.billing.dto.BillServiceDto;
import com.examples.microserv.billing.model.Bill;

import java.util.List;

public interface BillService {
     Bill createBill(Bill bill);
     List<Bill> getBills();
     Bill getBillDetailByBillControlNum(String billControlNum);
     Bill getBillDetailBySpCodeAndBillControlNum(BillServiceDto billServiceDto);
     Bill updateBillDetailByPaidStatus(BillServiceDto billServiceDto);
     Bill getBillDetailByBillIdAndSpCodeAndBillControlNum(BillServiceDto billServiceDto);
}
