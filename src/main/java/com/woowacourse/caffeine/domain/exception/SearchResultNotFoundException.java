package com.woowacourse.caffeine.domain.exception;

import com.woowacourse.caffeine.application.exception.ErrorResponseException;
import org.springframework.http.HttpStatus;

public class SearchResultNotFoundException extends ErrorResponseException {
    private static final String SEARCH_RESULT_NOT_FOUND_MESSAGE = "가게 검색 결과를 찾을 수 없습니다.";

    public SearchResultNotFoundException() {
        super(SEARCH_RESULT_NOT_FOUND_MESSAGE, HttpStatus.NOT_FOUND);
    }
}
