package com.examples.microserv.billing.dto;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Slf4j
public class PaymentDto {
    private String id;
    private String spCode;
    private String pspCode;
    private String billControlNumber;
    private String paymentReceipt;
    private Double paidAmount;
    private String billCurrency;
    private String payerEmail;
    private String paidDate;
    private String paymentReceivedDate;
}
