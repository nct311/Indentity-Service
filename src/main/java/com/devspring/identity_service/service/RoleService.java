package com.devspring.identity_service.service;

import com.devspring.identity_service.dto.request.RoleRequest;
import com.devspring.identity_service.dto.response.RoleRespone;
import com.devspring.identity_service.mapper.RoleMapper;
import com.devspring.identity_service.repository.PermissionRepository;
import com.devspring.identity_service.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleRespone create(RoleRequest request){
        var role = roleMapper.toRole(request);

        var permission= permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permission));

        role =  roleRepository.save(role);
        return roleMapper.toRoleRespone(role);
    }

    public List<RoleRespone> getAll(){
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleRespone)
                .toList();
    }

    public void delete(String role){
         roleRepository.deleteById(role);
    }
}
