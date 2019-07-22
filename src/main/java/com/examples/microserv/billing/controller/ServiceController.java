package com.examples.microserv.billing.controller;

import com.examples.microserv.billing.config.GlobalMethod;
import com.examples.microserv.billing.dto.MessageDto;
import com.examples.microserv.billing.dto.SpServiceDo;
import com.examples.microserv.billing.model.Services;
import com.examples.microserv.billing.service.ServiceService;
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
@RequestMapping("/services")

public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private GlobalMethod globalMethod;
    @PostMapping
    public ResponseEntity<MessageDto> createSpServices(@RequestBody @Valid Services services)
    {
        ResponseEntity<MessageDto> messageResponse=null;
        try {
            Services services1 = serviceService.createService(services);
            if (services1 != null){
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                        "/{id}").buildAndExpand(services1.getServiceId()).toUri();
                messageResponse=ResponseEntity.created(location).body(globalMethod.getResponse(services1.getServiceId(), "Services Created Sucessfully"));
            }

        }catch (Exception e){
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
    public List<Services> getAllServices()
    {
        List<Services> servicesList;
        try {
            servicesList=serviceService.getServices();
        }catch (Exception e){
            servicesList=null;
        }
        return servicesList;
    }

//    @PostMapping
//    public SpServiceDo getSpServicesBySpCode(){
//        SpServiceDo spServiceDo;
//        try {
//            spServiceDo= new SpServiceDo();
//            spServiceDo.setServicesList(serviceService.getServices());
//        }catch (Exception e){
//            e.printStackTrace();
//            spServiceDo=null;
//        }
//        return spServiceDo;
//    }
}
