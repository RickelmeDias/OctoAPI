package com.octopodius.OctoAPI.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.octopodius.OctoAPI.entities.User;
import org.springframework.beans.factory.annotation.Value;
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
        String token = JWT.create()
                .withIssuer("OctoAPI")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(expirationDate())
                .sign(algorithm);
        return token;
    }

    private Instant expirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

}
