package com.devspring.identity_service.controller;

import com.devspring.identity_service.dto.request.ApiResponse;
import com.devspring.identity_service.dto.request.PermissionRequest;
import com.devspring.identity_service.dto.response.PermissionRespone;
import com.devspring.identity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionRespone> createPermission(@RequestBody PermissionRequest request){
        return ApiResponse.<PermissionRespone>builder()
                .result(permissionService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<PermissionRespone>> getAll() {
        return ApiResponse.<List<PermissionRespone>>builder()
                .result(permissionService.getAll())
                .build();
    }

    @DeleteMapping("{permission}")
    ApiResponse<Void>  deletePermission(@PathVariable String permission){
        permissionService.delete(permission);
        return ApiResponse.<Void>builder().build();
    }

}
