package com.coface.corp.autonomy.gateway.config;

import com.coface.corp.autonomy.gateway.model.Role;
import com.coface.corp.autonomy.gateway.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Get user info :{}", username);
        User user = new User();
        user.setUsername(username);

        List<Role> roles = new ArrayList<>();
        roles.add(new Role("AUTONOMY_ADMIN"));

        user.setAuthorities(roles);

        return user;
    }
}
