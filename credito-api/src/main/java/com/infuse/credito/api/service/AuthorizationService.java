package com.infuse.credito.api.service;

import com.infuse.credito.api.model.User;
import com.infuse.credito.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    private final UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public UserDetails findByLogin(String login) {
        return repository.findByLogin(login);
    }

    public User save(User user) {
        return repository.save(user);
    }
}
