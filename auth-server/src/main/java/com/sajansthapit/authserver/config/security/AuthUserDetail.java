package com.sajansthapit.authserver.config.security;import com.fasterxml.jackson.annotation.JsonIgnore;import com.sajansthapit.authserver.authuser.model.AuthUser;import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.UserDetails;import java.util.Collection;import java.util.List;import java.util.stream.Collectors;public class AuthUserDetail implements UserDetails {    private final String id;    private final String username;    private final String email;    private final boolean  accountNonExpired;    private final boolean accountNonLocked;    private final boolean credentialNonExpired;    private final boolean enabled;    @JsonIgnore    private final String password;    private final Collection<? extends GrantedAuthority> authorities;    public AuthUserDetail(String id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialNonExpired, boolean enabled) {        this.id = id;        this.username = username;        this.email = email;        this.password = password;        this.authorities = authorities;        this.accountNonExpired = accountNonExpired;        this.accountNonLocked = accountNonLocked;        this.credentialNonExpired = credentialNonExpired;        this.enabled = enabled;    }    @Override    public Collection<? extends GrantedAuthority> getAuthorities() {        return authorities;    }    @Override    public String getPassword() {        return password;    }    @Override    public String getUsername() {        return username;    }    @Override    public boolean isAccountNonExpired() {        return accountNonExpired;    }    @Override    public boolean isAccountNonLocked() {        return accountNonLocked;    }    @Override    public boolean isCredentialsNonExpired() {        return credentialNonExpired;    }    @Override    public boolean isEnabled() {        return enabled;    }    public String id() {        return id;    }    public String getEmail() {        return email;    }    public static AuthUserDetail build(AuthUser authUser) {        List<GrantedAuthority> authorities = authUser.getAuthRoles().stream()                .map(role -> new SimpleGrantedAuthority(role.getName()))                .collect(Collectors.toList());        return new AuthUserDetail(authUser.getId(), authUser.getUsername(), authUser.getEmail()                , authUser.getPassword(), authorities, authUser.isAccountNonExpired(), authUser.isAccountNonLocked(), authUser.isCredentialNonExpired(),authUser.isEnabled());    }}