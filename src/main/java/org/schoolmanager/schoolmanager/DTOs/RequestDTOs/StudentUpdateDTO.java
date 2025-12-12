package org.schoolmanager.schoolmanager.DTOs.RequestDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record StudentUpdateDTO(String firstName,
                               String middleName,
                               String lastName,
                               String email,
                               Integer currentYear,

                               @JsonFormat(pattern = "yyyy-MM-dd")
                               LocalDate dateOfBirth,

                               String programme,
                               String phoneNumber,
                               String gender,
                               String address) {
}
