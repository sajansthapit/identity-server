package com.sajansthapit.authserver.authclient.repository;import com.sajansthapit.authserver.authclient.models.AuthClient;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.stereotype.Repository;@Repositorypublic interface AuthClientRepository extends JpaRepository<AuthClient, String> {}