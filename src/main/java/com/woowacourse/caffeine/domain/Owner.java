package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.application.exception.InvalidPasswordException;
import com.woowacourse.caffeine.application.exception.InvalidShopAddressException;
import com.woowacourse.caffeine.application.exception.PasswordMisMatchException;
import com.woowacourse.caffeine.domain.exception.InvalidEmailException;
import com.woowacourse.caffeine.domain.exception.InvalidShopNameException;
import lombok.Getter;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.regex.Pattern;

@Entity
@Getter
public class Owner {

    private static final String SHOP_NAME_REGEX = "^[a-zA-Z0-9가-힣\\s]{1,20}$";
    private static final String SHOP_ADDRESS_REGEX = "^[a-zA-Z0-9가-힣\\s()]{1,100}$";
    private static final String EMAIL_REGEX = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*d)(?=.*[$@$!%*#?&])[A-Za-zd$@$!%*#?&]{8,}$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String shopAddress;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Owner(String shopName, String shopAddress, String email, String password) {
        checkValid(shopName, shopAddress, email, password);
        this.shopName = shopName.trim();
        this.shopAddress = shopAddress.trim();
        this.email = email.trim();
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    protected Owner() {
    }

    private void checkValid(String shopName, String shopAddress, String email, String password) {
        checkShopName(shopName);
        checkShopAddress(shopAddress);
        checkEmail(email);
        checkPassword(password);
    }

    private void checkShopName(String shopName) {
        if (shopName.trim().isEmpty() || !Pattern.matches(SHOP_NAME_REGEX, shopName)) {
            throw new InvalidShopNameException(shopName);
        }
    }

    private void checkShopAddress(String shopAddress) {
        if (shopAddress.trim().isEmpty() || !Pattern.matches(SHOP_ADDRESS_REGEX, shopAddress)) {
            throw new InvalidShopAddressException();
        }
    }

    private void checkEmail(String email) {
        if (email.trim().isEmpty() || !Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidEmailException();
        }
    }

    private void checkPassword(String password) {
        if (password.trim().isEmpty() || !Pattern.matches(PASSWORD_REGEX, password)) {
            throw new InvalidPasswordException();
        }
    }

    public void authenticate(String password) {
        if (!BCrypt.checkpw(password, this.password)) {
            throw new PasswordMisMatchException();
        }
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
    }
}
