package com.sajansthapit.authserver.authuser.service.impl;import com.sajansthapit.authserver.authuser.repository.AuthUserRepository;import com.sajansthapit.authserver.authuser.service.IAuthUserService;import org.springframework.stereotype.Service;@Servicepublic class AuthUserService implements IAuthUserService {    private final AuthUserRepository authUserRepository;    public AuthUserService(AuthUserRepository authUserRepository) {        this.authUserRepository = authUserRepository;    }}