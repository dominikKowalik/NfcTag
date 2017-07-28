package com.kowalik.dominik.nfc.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dominik on 27.07.17.
 */
@Data
@Document
@Builder
@ToString
@AllArgsConstructor
public class User {

    @Id
    private String login;
    private String passwordHash;
    private Role role;

    public enum Role {
        ADMIN, USER
    }

}
