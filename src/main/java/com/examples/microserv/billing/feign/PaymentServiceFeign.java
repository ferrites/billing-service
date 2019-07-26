package com.examples.microserv.billing.feign;

import com.examples.microserv.billing.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "payment-service")
@Component
public interface PaymentServiceFeign {
    @GetMapping("/payments")
    List<PaymentDto> getAllPayment();

}
