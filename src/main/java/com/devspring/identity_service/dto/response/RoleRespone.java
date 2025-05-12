package com.devspring.identity_service.dto.response;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRespone {
    String name;
    String description;
    Set<PermissionRespone> permissions;
}
