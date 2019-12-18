package com.woowacourse.caffeine.presentation.controller.exceptionhandler;

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
