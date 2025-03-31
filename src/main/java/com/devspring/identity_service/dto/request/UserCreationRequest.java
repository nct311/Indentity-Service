package com.devspring.identity_service.dto.request;

import com.devspring.identity_service.exception.ErrorCode;
import com.devspring.identity_service.validator.DobConstraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 3, message ="USERNAME_INVAILD")
     String username;
    @Size(min = 8, message = "PASSWORD_INVAILD")
     String password;
     String firstName;
     String lastName;

     @DobConstraint(min = 18,message = "INVALID_DOB")
     LocalDate dob;


}
