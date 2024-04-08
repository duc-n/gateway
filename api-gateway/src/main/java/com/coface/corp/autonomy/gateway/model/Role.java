package com.coface.corp.autonomy.gateway.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {


    public Role(String name) {
        this.name = name;
    }

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return this.name;
    }


    @Override
    public String toString() {
        return "Role [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object that) {

        if (this == that)
            return true;

        if (!(that instanceof Role))
            return false;

        Role thatRole = (Role) that;

        return this.name.equals(thatRole.name);
    }


}