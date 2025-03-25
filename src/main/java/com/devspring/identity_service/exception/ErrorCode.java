package com.devspring.identity_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED(9999, "Uncategorized", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1001, "User existed" , HttpStatus.BAD_REQUEST),
    USERNAME_INVAILD(1002, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    PASSWORD_INVAILD(1003, "Password must be at least 8 characters long", HttpStatus.BAD_REQUEST),
    INVALID_KEY(1004, "Invalid key", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006,"UNAuthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"You do not have permission",HttpStatus.FORBIDDEN),

    ;
    private int code;
    private String message;
    private HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message , HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }



}
