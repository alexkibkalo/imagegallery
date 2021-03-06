package com.agileengine.imagegallery.persistence.entity.user;

import com.agileengine.imagegallery.persistence.entity.general.IdEntityCreatedUpdatedDeleted;
import com.agileengine.imagegallery.persistence.entity.token.Token;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends IdEntityCreatedUpdatedDeleted implements UserDetails {

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Token token;

    private boolean enabled;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "users_authority", joinColumns = @JoinColumn(name = "user_id"))
    private List<UserRole> authorities = new ArrayList<>();

    @Override
    public String getUsername() {
        return "email@gmail.com";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}