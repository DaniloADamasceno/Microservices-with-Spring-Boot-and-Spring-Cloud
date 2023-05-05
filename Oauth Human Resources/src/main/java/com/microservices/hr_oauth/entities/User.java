package com.microservices.hr_oauth.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class User implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();


    //?---------------------------------------------  Constructors  ----------------------------------------------------
    public User() {
    }

    public User(Long id, String name, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //?---------------------------------------------  Getters and Setters  ---------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //?---------------------------------------------  UserDetails METHODS ----------------------------------------------
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(x -> new SimpleGrantedAuthority(x.getRoleName())).
                collect(Collectors.toList());
    }

    public String getPassword() {                           //-> Método que retorna a senha do usuário
        return password;
    }

    @Override
    public String getUsername() {                           //-> Método que retorna o nome do usuário
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {                    //-> verifica se a conta do usuário está expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {                     //-> verifica se a conta do usuário está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {                //-> verifica se as credenciais do usuário estão expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {                              //-> Método que verifica se o usuário está ativo
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //?---------------------------------------------  HashCode and Equals  ---------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}