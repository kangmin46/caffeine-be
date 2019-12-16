package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.application.exception.InvalidNickNameException;
import com.woowacourse.caffeine.application.exception.InvalidPasswordException;
import com.woowacourse.caffeine.application.exception.PasswordMisMatchException;
import com.woowacourse.caffeine.domain.exception.InvalidEmailException;
import com.woowacourse.caffeine.domain.exception.InvalidOwnerIdException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.regex.Pattern;

@Entity
public class Owner {
    private static final String OWNER_ID_REGEX = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
    private static final String EMAIL_REGEX = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
    private static final String NICK_NAME_REGEX = "^[wWㄱ-ㅎㅏ-ㅣ가-힣]{2,20}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*d)(?=.*[$@$!%*#?&])[A-Za-zd$@$!%*#?&]{8,}$";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ownerId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public Owner(String ownerId, String nickName, String email, String password) {
        checkValid(ownerId, nickName, email, password);
        this.ownerId = ownerId;
        this.nickName = nickName;
        this.email = email;
        this.password = password;
    }

    protected Owner() {
    }

    private void checkValid(String ownerId, String nickName, String email, String password) {
        checkOwnerId(ownerId);
        checkNickName(nickName);
        checkEmail(email);
        checkPassword(password);
    }

    private void checkOwnerId(String ownerId) {
        if(!Pattern.matches(OWNER_ID_REGEX, ownerId)) {
            throw new InvalidOwnerIdException();
        }
    }

    private void checkNickName(String nickName) {
        if(!Pattern.matches(NICK_NAME_REGEX, nickName)) {
            throw new InvalidNickNameException();
        }
    }

    private void checkEmail(String email) {
        if(!Pattern.matches(EMAIL_REGEX, email)) {
            throw new InvalidEmailException();
        }
    }

    private void checkPassword(String password) {
        if(!Pattern.matches(PASSWORD_REGEX, password)) {
            throw new InvalidPasswordException();
        }
    }

    public Long getId() {
        return id;
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

    public void checkLoginPassword(String password) {
        if(!this.password.equals(password)) {
            throw new PasswordMisMatchException();
        }
    }
}
