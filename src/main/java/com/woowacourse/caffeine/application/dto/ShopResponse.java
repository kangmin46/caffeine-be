package com.woowacourse.caffeine.application.dto;

public class ShopResponse {

<<<<<<< HEAD
    public final long id;
    public final String name;

    public ShopResponse(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
=======
    private Long id;
    private String name;
    private String image;
    private String address;
    private String phoneNumber;

    public ShopResponse() {
    }

    public ShopResponse(final Long id, final String name, final String image, final String address, final String phoneNumber) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
        return id;
    }

    public String getName() {
        return name;
    }
<<<<<<< HEAD
=======

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}
