package com.woowacourse.caffeine.application.dto;

public class ShopCreateRequest {

    private String name;
<<<<<<< HEAD
=======
    private String image;
    private String address;
    private String phoneNumber;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef

    public ShopCreateRequest() {
    }

<<<<<<< HEAD
    public ShopCreateRequest(final String name) {
        this.name = name;
=======
    public ShopCreateRequest(final String name, final String image, final String address, final String phoneNumber) {
        this.name = name;
        this.image = image;
        this.address = address;
        this.phoneNumber = phoneNumber;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
<<<<<<< HEAD
=======

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}
