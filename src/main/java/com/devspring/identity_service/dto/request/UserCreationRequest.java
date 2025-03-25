package com.devspring.identity_service.dto.request;

import com.devspring.identity_service.exception.ErrorCode;
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
     LocalDate dob;


}
