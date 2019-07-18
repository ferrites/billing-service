package com.examples.microserv.billing.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/*Bill [id,spId,billControlNumber,billAmount,billedDate,expirationDate,serviceId,billCurrency,customerEmail,isPaid]*/
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Slf4j
public class Bill {
    @Id
    @Column(name = "billId")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String billId;
    @Column(name = "spId")
    private String spId;
    @Column(name = "billControlNumber")
    private String billControlNumber;
    @Column(name = "billAmount")
    private Double billAmount;
    @Column(name = "billedDate")
    private String billedDate;
    @Column(name = "expirationDate")
    private Date expirationDate;
    @Column(name = "serviceId")
    private String serviceId;
    @Column(name = "billCurrencyCode")
    private String billCurrencyCode;
    @Column(name = "customerEmail")
    private String customerEmail;
    @Column(name = "isPaid")
    private boolean isPaid;
    @Column(name = "spCode")
    private String spCode;

}
