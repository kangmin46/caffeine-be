package com.woowacourse.caffeine.application.dto;

public class LoginRequest {
    private String ownerId;
    private String password;

    public LoginRequest(String ownerId, String password) {
        this.ownerId = ownerId;
        this.password = password;
    }

    public LoginRequest() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getPassword() {
        return password;
    }
}
