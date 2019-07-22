package com.examples.microserv.billing.dto;

import com.examples.microserv.billing.model.Services;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Slf4j
public class SpServiceDo {
    private List<Services> servicesList;

}
