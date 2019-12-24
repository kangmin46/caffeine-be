package com.woowacourse.caffeine.presentation.controller.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woowacourse.caffeine.application.dto.ShopResponses;
import com.woowacourse.caffeine.application.service.SearchService;
import com.woowacourse.caffeine.mock.ShopResponseRepository;
import com.woowacourse.caffeine.presentation.controller.SearchController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static com.woowacourse.caffeine.presentation.controller.SearchController.V1_SEARCH;
import static com.woowacourse.caffeine.utils.ApiDocumentUtils.getDocumentRequest;
import static com.woowacourse.caffeine.utils.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
@AutoConfigureRestDocs
public class SearchDocumentationTest {
    private static final Logger logger = LoggerFactory.getLogger(SearchDocumentationTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchService searchService;

    @Test
    void search() throws Exception {
        final ShopResponses shopResponses = new ShopResponses(
            Arrays.asList(ShopResponseRepository.shopResponse1, ShopResponseRepository.shopResponse2));

        given(searchService.search(any())).willReturn(shopResponses);

        ResultActions perform = mockMvc.perform(RestDocumentationRequestBuilders
            .get(V1_SEARCH + "/?query=keyWord%3Daddress,contents%3D송파구"));

        perform.andExpect(status().isOk())
            .andDo(print())
            .andDo(document("search", getDocumentRequest(), getDocumentResponse()));
    }
}
