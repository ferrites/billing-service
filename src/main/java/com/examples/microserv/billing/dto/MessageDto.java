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
public class MessageDto {
    private Integer statusCode;
    private String status;
    private Integer id;
    private String message;
}


