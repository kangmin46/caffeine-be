package com.woowacourse.caffeine.domain;

import com.woowacourse.caffeine.domain.exception.InvalidMenuItemNameException;
<<<<<<< HEAD
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemPriceException;
=======
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemNameInEnglishException;
import com.woowacourse.caffeine.domain.exception.InvalidMenuItemPriceException;
import org.junit.jupiter.api.BeforeEach;
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuItemTest {

<<<<<<< HEAD
    @Test
    void create() {
        // given
        String name = "아메리카노";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = 2500;
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertDoesNotThrow(() -> new MenuItem(name, description, price, shop));
    }

    @Test
    void name_empty() {
        // given
        String name = "";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = 2500;
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertThrows(InvalidMenuItemNameException.class, () -> new MenuItem(name, description, price, shop));
=======
    String name;
    String nameInEnglish;
    String description;
    int price;
    String img;
    String category;
    Shop shop;

    @BeforeEach
    void setUp() {
        name = "아메리카노";
        nameInEnglish = "Americano";
        description = "아메리카노 좋아~ 좋아~ 좋아";
        price = 2500;
        img = "abc";
        category = "coffee";
        shop = new Shop("어디야 커피");
    }

    @Test
    void create() {
        // when & then
        assertDoesNotThrow(() -> new MenuItem(name, nameInEnglish, description, price, img, category, shop));
    }

    @Test
    void name_empty() {
        // given
        String emptyName = "";

        // when & then
        assertThrows(InvalidMenuItemNameException.class, () -> new MenuItem(emptyName, nameInEnglish, description, price, img, category, shop));
    }

    @Test
    void nameInEnglish_with_korean() {
        // given
        String nameInEnglishWithKorean = "암에리카노";

        // when & then
        assertThrows(InvalidMenuItemNameInEnglishException.class, () -> new MenuItem(name, nameInEnglishWithKorean, description, price, img, category, shop));
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    }

    @Test
    void price_minus() {
        // given
<<<<<<< HEAD
        String name = "아메리카노";
        String description = "아메리카노 좋아~ 좋아~ 좋아~";
        int price = -2500;
        Shop shop = new Shop("어디야 커피");

        // when & then
        assertThrows(InvalidMenuItemPriceException.class, () -> new MenuItem(name, description, price, shop));
=======
        int minusPrice = -2500;

        // when & then
        assertThrows(InvalidMenuItemPriceException.class, () -> new MenuItem(name, nameInEnglish, description, minusPrice, img, category, shop));
>>>>>>> 7da09fa83d2c5c6b01e722babfddb0e8de165bef
    }
}
