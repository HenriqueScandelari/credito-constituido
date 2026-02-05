package com.infuse.credito.api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.infuse.credito.api.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("credito-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(getExpireInstant())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating token", e);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            var verifier = JWT.require(algorithm)
                    .withIssuer("credito-api")
                    .build();
            var decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant getExpireInstant() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
