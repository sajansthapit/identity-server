package com.sajansthapit.authserver.authuser.model;import jakarta.persistence.*;import java.util.HashSet;import java.util.Set;@Entity@Table(name = "auth_user")public class AuthUser {    @Id    private String id;    private String fullName;    private String email;    private String username;    private String password;    @ManyToMany(fetch = FetchType.LAZY)    @JoinTable(name = "auth_user_roles",    joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"))    private Set<AuthRole> authRoles = new HashSet<>();    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getFullName() {        return fullName;    }    public void setFullName(String fullName) {        this.fullName = fullName;    }    public String getEmail() {        return email;    }    public void setEmail(String email) {        this.email = email;    }    public String getUsername() {        return username;    }    public void setUsername(String username) {        this.username = username;    }    public String getPassword() {        return password;    }    public void setPassword(String password) {        this.password = password;    }    public Set<AuthRole> getAuthRoles() {        return authRoles;    }    public void setAuthRoles(Set<AuthRole> authRoles) {        this.authRoles = authRoles;    }}