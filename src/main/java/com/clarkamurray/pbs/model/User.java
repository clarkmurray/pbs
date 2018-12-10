package com.clarkamurray.pbs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class User implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 99)
    @JsonIgnore
    private String password;

    @Column(length = 40)
    private String email;

    @Column(columnDefinition = "BOOLEAN DEFAULT '1'")
    private Boolean active;

    // Timestamp createdAt

    // Timestamp updatedAt

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() { return true; }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() { return true; }

}
