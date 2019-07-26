package com.examples.microserv.billing.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Slf4j
public class BillServiceDto {
    private String billId;
    private String spId;
    private String billControlNumber;
    private Double billAmount;
    private String billedDate;
    private Date expirationDate;
    private String serviceId;
    private String billCurrencyCode;
    private String customerEmail;
    private boolean isPaid;
    private String spCode;


}
