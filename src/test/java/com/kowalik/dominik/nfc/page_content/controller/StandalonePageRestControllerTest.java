package com.kowalik.dominik.nfc.page_content.controller;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import com.kowalik.dominik.nfc.page_content.repository.PageMongoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.kowalik.dominik.nfc.TestJsonUtils.APPLICATION_JSON_UTF8;
import static com.kowalik.dominik.nfc.TestJsonUtils.convertObjectToJson;
import static org.assertj.core.util.Lists.newArrayList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Matchers.eq;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.isA;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dominik on 28.07.17.
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StandalonePageRestControllerTest {
    MockMvc mockMvc;

    @Mock
    PageMongoRepository pageMongoRepository;

    private static final Integer ID = 1;
    private static final String BODY = "example body";
    private static final String LONG_BODY = "long long long long long long long long long long body";
    private static final String HEADER = "example header";
    private static final String PATH = "/page";
    private static final Page PAGE = Page.builder().id(1L).body(BODY).header(HEADER).build();
    private static final Page INVALID_PAGE = Page.builder().id(1L).build();
    private static final Page PAGE_WITH_LONG_BODY = Page.builder().id(1L).body(LONG_BODY).header(HEADER).build();
    private static final List<Page> PAGE_LIST = newArrayList(PAGE, PAGE_WITH_LONG_BODY);

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new PageRestController(pageMongoRepository))
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .build();
    }

    @Test
    public void get_pageExists_returnsOk() throws Exception {
        //given
        when(pageMongoRepository.findOne(eq(1L))).thenReturn(PAGE);
        //when
        mockMvc.perform(get(PATH + "/" + ID))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.body", is(BODY)))
                .andExpect(jsonPath("$.header", is(HEADER)))
                .andExpect(jsonPath("$.id", is(ID)));
    }

    @Test
    public void getAll_pagesExist_returnsOk() throws Exception {
        //given
        when(pageMongoRepository.findAll()).thenReturn(PAGE_LIST);
        //when
        mockMvc.perform(get(PATH))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].body", hasItem(BODY)))
                .andExpect(jsonPath("$[*].body", hasItem(LONG_BODY)));
    }

    @Test
    public void get_pageDoesNotExist_returnsNotFound() throws Exception {
        //given
        when(pageMongoRepository.findOne(eq(1L))).thenReturn(null);
        //when
        mockMvc.perform(get(PATH + "/" + ID))
                //then
                .andExpect(status().isNotFound());
    }

    @Test
    public void save_invalidPage_returnsBadRequest() throws Exception {
        //given
        when(pageMongoRepository.save(isA(Page.class))).thenAnswer(invocation -> invocation.getArguments()[0]);
        //when
        mockMvc.perform((post(PATH).contentType(APPLICATION_JSON_UTF8).content(convertObjectToJson(INVALID_PAGE))))
                //then
                .andExpect(status().isBadRequest());
        verify(pageMongoRepository, times(0)).save(isA(Page.class));
    }

    @Test
    public void save_validPage_returnsOk() throws Exception {
        //given
        when(pageMongoRepository.save(isA(Page.class))).thenAnswer(invocation -> invocation.getArguments()[0]);
        //when
        mockMvc.perform((post(PATH).contentType(APPLICATION_JSON_UTF8).content(convertObjectToJson(PAGE))))
                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.body", is(BODY)))
                .andExpect(jsonPath("$.header", is(HEADER)))
                .andExpect(jsonPath("$.id", is(ID)));
    }
}