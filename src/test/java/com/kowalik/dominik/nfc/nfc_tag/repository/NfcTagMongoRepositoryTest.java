//package com.kowalik.dominik.nfc.nfcTag.repository;
//
//import com.kowalik.dominik.nfc.Application;
//import com.kowalik.dominik.nfc.nfc_tag.domain.NfcTag;
//import org.assertj.core.api.Assertions;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by dominik on 27.07.17.
// */
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {Application.class})
//@TestPropertySource("classpath:mongo-test.properties")
//public class NfcTagMongoRepositoryTest {
//    @Autowired
//    NfcTagMongoRepository nfcTagMongoRepository;
//
//    private static final NfcTag ADMIN_TAG = NfcTag.builder().id(1L).isAdminTag(true).tagId("aaa").build();
//
//    @After
//    public void clearDb(){
//        nfcTagMongoRepository.deleteAll();
//    }
////
//     @Test
//    public void findAll_oneNfcTagInRepo_returnsTags(){
////        //given
//      nfcTagMongoRepository.save(ADMIN_TAG);
//         //when
//        List<NfcTag> nfc_tag = nfcTagMongoRepository.findAll();
////        //then
//        Assertions.assertThat(nfc_tag.size()).isEqualTo(1);
//    }
//}