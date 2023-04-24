package com.octopodius.OctoAPI.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.octopodius.OctoAPI.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtTokenService {

    @Value("${api.octoapi.jwt.secret}")
    String secret_jwt;

    public String generateToken(User user) throws JWTCreationException {
        Algorithm algorithm = Algorithm.HMAC256(secret_jwt);
        return JWT.create()
                .withIssuer("OctoAPI")
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(expirationDate())
                .sign(algorithm);
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret_jwt);
            return JWT.require(algorithm)
                    .withIssuer("OctoAPI")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Invalid Authorization");
        }
    }

    public String getUserEmail() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user == null) {
            throw new RuntimeException("Invalid User");
        }
        return user.getEmail();
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

}
