package com.examples.microserv.billing.feign;

import com.examples.microserv.billing.model.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(name="billing-service")
@Component
public interface BillServiceFeign {
    @GetMapping("/bills")
    List<Bill> getAllBills();
}
