package com.kowalik.dominik.nfc.user.controller;

import com.kowalik.dominik.nfc.user.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dominik on 27.07.17.
 */

@RestController
@RequestMapping(path = "/user")
public class UserRestController {

    UserMongoRepository userMongoRepository;

    @Autowired
    public UserRestController(UserMongoRepository userMongoRepository){
        this.userMongoRepository = userMongoRepository;
    }
}
