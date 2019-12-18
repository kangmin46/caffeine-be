package com.woowacourse.caffeine.presentation.controller.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String status;
    private String message;

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse() {
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
