package com.examples.microserv.billing.config;

import com.examples.microserv.billing.dto.MessageDto;
import com.examples.microserv.billing.model.Bill;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class GlobalMethod {
    public MessageDto getResponse(String id, String message) {
        MessageDto response = new MessageDto();
        response.setId(id);
        response.setStatus(HttpStatus.OK.name());
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage(message);
        return response;
    }

    public MessageDto getErrorResponse(String id, String message) {
        MessageDto response = new MessageDto();
        response.setId(id);
        response.setStatus(HttpStatus.BAD_REQUEST.name());
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage(message);
        return response;
    }

    public String BillData(){
        String json=null;
        try {
            Bill bill =new Bill();
            bill.setSpId("231");
            bill.setBillControlNumber("991080000001");
            bill.setBillAmount(3500.00);
            bill.setBilledDate("2019-07-18 08:43");
            bill.setServiceId("17380");
            bill.setBillCurrencyCode("TZS");
            bill.setCustomerEmail("chumasitta@gmail.com");
            bill.setPaid(false);
            bill.setSpCode("SP108");
            ObjectMapper Obj = new ObjectMapper();
            json=Obj.writeValueAsString(bill);;

        }catch (Exception e){
            e.printStackTrace();

        }
        return json;


    }

}
