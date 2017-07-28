package com.kowalik.dominik.nfc.database.configuration;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by dominik on 27.07.17.
 */

//@Configuration
//@EnableMongoRepositories
public class MongoConfig {
    @Bean
    public MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(new MongoClient("localhost", 2707), "mongo_test");
    }
    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }
}
