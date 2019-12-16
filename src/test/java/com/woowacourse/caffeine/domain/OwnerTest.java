package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.application.exception.InvalidNickNameException;
import com.woowacourse.caffeine.application.exception.InvalidPasswordException;
import com.woowacourse.caffeine.domain.exception.InvalidEmailException;
import com.woowacourse.caffeine.domain.exception.InvalidOwnerIdException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OwnerTest {
    @Test
    void check_owner_id_korean() {
        assertThrows(InvalidOwnerIdException.class, () -> new Owner("로비", "코나스", "kangmin@gmail.com", "P@ssWord!@"));
    }

    @Test
    void check_owner_id_special_character() {
        assertThrows(InvalidOwnerIdException.class, () -> new Owner("!!@@", "코나스", "kangmin@gmail.com", "P@ssWord!@"));
    }

    @Test
    void check_owner_id_blank_empty() {
        assertThrows(InvalidOwnerIdException.class, () -> new Owner(" ", "코나스", "kangmin@gmail.com", "P@ssWord!@"));
        assertThrows(InvalidOwnerIdException.class, () -> new Owner("", "코나스", "kangmin@gmail.com", "P@ssWord!@"));
    }

    @Test
    void check_nick_name_special_character() {
        assertThrows(InvalidNickNameException.class, () -> new Owner("kangmin", "!!@@", "kangmin@gmail.com", "P@ssWord!@"));
    }

    @Test
    void check_nick_name_blank() {
        assertThrows(InvalidNickNameException.class, () -> new Owner("kangmin", " ", "kangmin@gmail.com", "P@ssWord!@"));
        assertThrows(InvalidNickNameException.class, () -> new Owner("kangmin", "", "kangmin@gmail.com", "P@ssWord!@"));
    }

    @Test
    void check_email_not_special_character() {
        assertThrows(InvalidEmailException.class, () -> new Owner("kangmin", "코나스", "kangmingmail.com", "P@ssWord!@"));
    }

    @Test
    void check_email_blank_empty() {
        assertThrows(InvalidEmailException.class, () -> new Owner("kangmin", "코나스", " ", "P@ssWord!@"));
        assertThrows(InvalidEmailException.class, () -> new Owner("kangmin", "코나스", "", "P@ssWord!@"));
    }

    @Test
    void check_password_not_special_character() {
        assertThrows(InvalidPasswordException.class, () -> new Owner("kangmin", "코나스", "kangmin@gmail.com", "PssWord"));
    }

    @Test
    void check_password_blank_empty() {
        assertThrows(InvalidPasswordException.class, () -> new Owner("kangmin", "코나스", "kangmin@gmail.com", " "));
        assertThrows(InvalidPasswordException.class, () -> new Owner("kangmin", "코나스", "kangmin@gmail.com", ""));
    }
}
