package com.examples.microserv.billing.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Slf4j
@Document(collection ="Service")
public class Services {
    @Id
    @Column(name = "serviceId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String serviceId;
    @Column(name = "spCode")
    private String spCode;
    @Column(name = "serviceCode")
    private String serviceCode;
    @Column(name = "serviceName")
    private String serviceName;

}
