package com.getfood.courier.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class CourierUser {
    private UUID id;
    private String name;
    private String registerNumber;
    private LocalDate birthdayDate;
    private Boolean active;
    private Boolean online;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
