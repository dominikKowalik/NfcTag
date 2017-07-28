package com.kowalik.dominik.nfc.group.repository;

import com.kowalik.dominik.nfc.Application;
import com.kowalik.dominik.nfc.group.domain.Branch;
import com.kowalik.dominik.nfc.nfc_tag.domain.NfcTag;
import com.kowalik.dominik.nfc.nfc_tag.repository.NfcTagMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dominik on 27.07.17.
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestPropertySource("classpath:mongo-test.properties")
public class BranchMongoRepositoryTest {
    @Autowired
    BranchMongoRepository branchMongoRepository;

    @Autowired
    NfcTagMongoRepository nfcTagMongoRepository;

    @Test
    public void findAll_oneGroup_returnsGroup() {
        //given
        List<NfcTag> nfcTags = new ArrayList<>();
        nfcTags.add(NfcTag.builder().tagId("!@s#R3sasda").isAdminTag(true).build());
        Branch branch = Branch.builder().groupNumber(1L).nfcTags(nfcTags).build();
        nfcTags.forEach(nfcTag -> nfcTagMongoRepository.save(nfcTag));
        branchMongoRepository.save(branch);
        //when
        List<Branch> groupList = branchMongoRepository.findAll();
        //then
        assertThat(groupList).hasSize(1);
        assertThat(groupList.get(0).getNfcTags()).hasSize(3);
    }
}