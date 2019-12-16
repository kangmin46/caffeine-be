package com.woowacourse.caffeine.application.dto;

public class SignUpRequest {
    private String ownerId;
    private String nickName;
    private String email;
    private String password;

    public SignUpRequest(String ownerId, String nickName, String email, String password) {
        this.ownerId = ownerId;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    public SignUpRequest() {
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
