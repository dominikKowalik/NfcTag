package com.kowalik.dominik.nfc.security.service;

import com.kowalik.dominik.nfc.security.model.CurrentUser;
import com.kowalik.dominik.nfc.user.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final String LOGIN = "LOGIN";

    private final UserMongoRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserMongoRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findOne(username))
                .map(user -> CurrentUser.builder()
                        .login(LOGIN)
                        .passwordHash(user.getPasswordHash())
                        .role(ROLE_PREFIX + user.getRole().name())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
