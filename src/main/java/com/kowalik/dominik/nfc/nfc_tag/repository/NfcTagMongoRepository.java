package com.kowalik.dominik.nfc.nfc_tag.repository;

import com.kowalik.dominik.nfc.nfc_tag.domain.NfcTag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dominik on 28.07.17.
 */
@Repository
public interface NfcTagMongoRepository extends MongoRepository<NfcTag,String> {
}
