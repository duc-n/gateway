package com.coface.corp.autonomy.gateway.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
public class User implements UserDetails {
    private String username;
    private String currentLanguage;

    private String title;
    private String email;
    private String firstName;
    private String lastName;
    private String subscriberId;
    private Set<String> managedEmployees;

    /* Spring Security related fields */
    private String password;
    private List<Role> authorities = new ArrayList<>();
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;


}
