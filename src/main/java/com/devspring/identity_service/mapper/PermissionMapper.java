package com.devspring.identity_service.mapper;

import com.devspring.identity_service.dto.request.PermissionRequest;
import com.devspring.identity_service.dto.request.UserCreationRequest;
import com.devspring.identity_service.dto.request.UserUpdateRequest;
import com.devspring.identity_service.dto.response.PermissionRespone;
import com.devspring.identity_service.dto.response.UserResponse;
import com.devspring.identity_service.entity.Permission;
import com.devspring.identity_service.entity.Role;
import com.devspring.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionRespone toPermissionRespone(Permission permission);


}
