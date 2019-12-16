package com.woowacourse.caffeine.domain;

<<<<<<< HEAD
import com.woowacourse.caffeine.domain.exception.InvalidShopNameException;

=======
import com.woowacourse.caffeine.application.dto.ShopCreateRequest;
import com.woowacourse.caffeine.domain.exception.InvalidShopNameException;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
<<<<<<< HEAD
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Shop {
<<<<<<< HEAD
=======
    private static final String DEFAULT_IMAGE =
        "https://github.com/eunsukko/TIL/blob/master/201912/caffeine/pictures/" +
            "starbucks_%EC%84%9D%EC%B4%8C%ED%98%B8%EC%88%98.jpg?raw=true";
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    private String name;

=======
    @Column(nullable = false)
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private String image;

    @NotNull
    private String address;

    @NotNull
    private String phoneNumber;

>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    @OneToMany(mappedBy = "vendor")
    private List<MenuItem> menus = new ArrayList<>();

    protected Shop() {
    }

    public Shop(final String name) {
        this.name = Objects.requireNonNull(name);
<<<<<<< HEAD

=======
        checkName(name);
    }

    public Shop(final String name, final String image, final String address, final String phoneNumber) {
        this.name = name;
        checkName(name);
        configImage(image);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private void checkName(final String name) {
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
        if (name.isEmpty()) {
            throw new InvalidShopNameException(name);
        }
    }

<<<<<<< HEAD
=======
    private void configImage(final String imageUrl) {
        if (StringUtils.isEmpty(imageUrl)) {
            this.image = DEFAULT_IMAGE;
            return;
        }
        this.image = imageUrl;
    }

    public static Shop create(final ShopCreateRequest shopCreateRequest) {
        return new Shop(
            shopCreateRequest.getName(),
            shopCreateRequest.getImage(),
            shopCreateRequest.getAddress(),
            shopCreateRequest.getPhoneNumber());
    }

>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    public void addMenu(final MenuItem menu) {
        menus.add(menu);
    }

    public Long getId() {
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
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
}
