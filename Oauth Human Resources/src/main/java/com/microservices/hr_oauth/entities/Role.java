package com.microservices.hr_oauth.entities;

import java.io.Serializable;
import java.util.Objects;


public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;


    //?----------------------------------------------  Constructors  ---------------------------------------------------
    public Role() {}

    public Role(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }


    //? -------------------------------------------  Getters & Setters  ------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    //?-------------------------------------------  HashCode & Equals  -------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}