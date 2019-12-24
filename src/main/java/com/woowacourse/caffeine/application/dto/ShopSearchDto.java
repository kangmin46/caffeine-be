package com.woowacourse.caffeine.application.dto;

public class ShopSearchDto {
    private String keyWord;
    private String contents;

    public ShopSearchDto(final String keyWord, final String contents) {
        this.keyWord = keyWord;
        this.contents = contents;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public String getContents() {
        return contents;
    }
}
