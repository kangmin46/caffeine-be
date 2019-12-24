package com.woowacourse.caffeine.support;

import com.woowacourse.caffeine.application.dto.ShopSearchDto;
import com.woowacourse.caffeine.application.exception.InvalidSearchRequestException;

public class SearchParser {
    private static final String SEARCH_DATA_SPLIT_DELIMITER = ",";
    private static final String SEARCH_KEY_VALUE_SPLIT_DELIMITER = "%3D";

    public static ShopSearchDto parse(final String query) {
        String[] searchEntrySet = query.split(SEARCH_DATA_SPLIT_DELIMITER);

        String[] keyWordKeyValue = searchEntrySet[0].split(SEARCH_KEY_VALUE_SPLIT_DELIMITER);
        String[] contentsKeyValue = searchEntrySet[1].split(SEARCH_KEY_VALUE_SPLIT_DELIMITER);
        checkValidKey(keyWordKeyValue[0], contentsKeyValue[0]);
        return new ShopSearchDto(keyWordKeyValue[1], contentsKeyValue[1]);
    }

    private static void checkValidKey(String keyWordKey, String contentsKey) {
        if(!keyWordKey.equals("keyWord") || !contentsKey.equals("contents")) {
            throw new InvalidSearchRequestException();
        }
    }
}
