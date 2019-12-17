package com.woowacourse.caffeine.application.dto;

public class SignUpRequest {
    private String email;
    private String password;
    private String shopName;
    private String shopAddress;

    public SignUpRequest(String email, String password, String shopName, String shopAddress) {
        this.email = email;
        this.password = password;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public SignUpRequest() {
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
