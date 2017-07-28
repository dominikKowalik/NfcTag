package com.kowalik.dominik.nfc.group.repository;

import com.kowalik.dominik.nfc.group.domain.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dominik on 27.07.17.
 */
@Repository
public interface BranchMongoRepository extends MongoRepository<Branch,Long> {
}
