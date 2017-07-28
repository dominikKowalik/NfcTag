package com.kowalik.dominik.nfc.page_content.repository;

import com.kowalik.dominik.nfc.page_content.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dominik on 28.07.17.
 */

@Repository
public interface PageMongoRepository extends MongoRepository<Page, Long> {

}
