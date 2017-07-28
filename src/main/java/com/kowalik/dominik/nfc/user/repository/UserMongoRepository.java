package com.kowalik.dominik.nfc.user.repository;

import com.kowalik.dominik.nfc.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dominik on 27.07.17.
 */

@Repository
public interface UserMongoRepository extends MongoRepository<User,String> {
}
