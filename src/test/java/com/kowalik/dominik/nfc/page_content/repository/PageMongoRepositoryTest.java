package com.kowalik.dominik.nfc.page_content.repository;

import com.kowalik.dominik.nfc.Application;
import com.kowalik.dominik.nfc.page_content.domain.Page;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dominik on 28.07.17.
 */


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource("classpath:application.properties")
public class PageMongoRepositoryTest {

    @Autowired
    PageMongoRepository pageMongoRepository;

    @Test
    public void findAll_oneGroup_returnsGroup() {
        //given
        Page page = Page.builder().id(1L).header("asdsasadasdadas").body("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadddddddddddddddddddddsaaaaa").build();
        pageMongoRepository.save(page);
        //when
        List<Page> returnedPage = pageMongoRepository.findAll();
        //then
        Assertions.assertThat(returnedPage).hasSize(1);
    }
}
