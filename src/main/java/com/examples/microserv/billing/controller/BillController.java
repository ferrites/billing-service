package com.examples.microserv.billing.controller;

import com.examples.microserv.billing.config.GlobalMethod;
import com.examples.microserv.billing.dto.MessageDto;
import com.examples.microserv.billing.model.Bill;
import com.examples.microserv.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private GlobalMethod globalMethod;
    @PostMapping
    public ResponseEntity<MessageDto> createBill(@RequestBody @Valid Bill bill)
    {
        ResponseEntity<MessageDto> messageResponse=null;
        try {
            Bill bill1= billService.createBill(bill);
            if (bill1 != null){
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                        "/{id}").buildAndExpand(bill1.getBillId()).toUri();
                messageResponse=ResponseEntity.created(location).body(globalMethod.getResponse(bill1.getBillId(), "Bill Created Sucessfully"));
            }

        }catch (Exception e){
//            LoggerFactory.
            e.printStackTrace();
            messageResponse=null;

        }
        return messageResponse;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MessageDto> handleValidationException(MethodArgumentNotValidException ex)
    {
        FieldError error = ex.getBindingResult().getFieldError("name");
        System.out.println("Error Message: " + (error != null ? error.getCode() : null) + " - " + (error != null ? error.getDefaultMessage() : null));
        return ResponseEntity.badRequest().body(globalMethod.getErrorResponse("", error != null ? error.getDefaultMessage() : null));

    }
    @GetMapping
    public List<Bill> getAll()
    {
        return billService.getBills();
    }

    @GetMapping("/test ")
    public String testUrl(){
        return  "Info";
    }
}
