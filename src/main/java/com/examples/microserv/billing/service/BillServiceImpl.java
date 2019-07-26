package com.examples.microserv.billing.service;

import com.examples.microserv.billing.Repository.BillRepository;
import com.examples.microserv.billing.dto.BillServiceDto;
import com.examples.microserv.billing.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository billRepository;
    private Query query;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    @Override
    public Bill getBillDetailByBillControlNum(String billControlNum) {
        Bill bill;
        try {
            query = new Query();
            query.addCriteria(Criteria.where("billControlNumber").is(billControlNum));
            bill = mongoTemplate.findOne(query, Bill.class);
        } catch (Exception e) {
            bill = null;

        }
        return bill;
    }

    @Override
    public Bill getBillDetailBySpCodeAndBillControlNum(BillServiceDto billServiceDto) {
        Bill bill;
        try {
            query = new Query();
            query.addCriteria(Criteria.where("billControlNumber").is(billServiceDto.getBillControlNumber()).andOperator(Criteria.where("spCode").is(billServiceDto.getSpCode())));
            bill = mongoTemplate.findOne(query, Bill.class);
        } catch (Exception e) {
            bill = null;
        }
        return bill;
    }

    @Override
    public Bill updateBillDetailByPaidStatus(BillServiceDto billServiceDto) {
        Bill bill;
        try {
            bill=this.getBillDetailByBillIdAndSpCodeAndBillControlNum(billServiceDto);
            if (bill!=null){
                bill.setPaid(billServiceDto.isPaid());
                billRepository.save(bill);
            }
        } catch (Exception e) {
            bill = null;
        }
        return bill;
    }

    @Override
    public Bill getBillDetailByBillIdAndSpCodeAndBillControlNum(BillServiceDto billServiceDto) {
        Bill bill;
        try {
            query = new Query();
            query.addCriteria(Criteria.where("billControlNumber").is(billServiceDto.getBillControlNumber()).andOperator(Criteria.where("spCode").is(billServiceDto.getSpCode())).andOperator(Criteria.where("billId").is(billServiceDto.getSpCode())));
            bill = mongoTemplate.findOne(query, Bill.class);
        } catch (Exception e) {
            bill = null;
        }
        return bill;
    }
}
