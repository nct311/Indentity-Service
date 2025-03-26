package com.devspring.identity_service.service;

import com.devspring.identity_service.dto.request.PermissionRequest;
import com.devspring.identity_service.dto.response.PermissionRespone;
import com.devspring.identity_service.entity.Permission;
import com.devspring.identity_service.mapper.PermissionMapper;
import com.devspring.identity_service.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionRespone create(PermissionRequest request){
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionRespone(permission);

    }
    public List<PermissionRespone> getAll(){
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionRespone).toList();
    }

    public void delete(String permission){
        permissionRepository.deleteById(permission);
    }
}
