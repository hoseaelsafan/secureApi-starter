package com.dee.secure_api.config;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    private Key key;

    @PostConstruct
    public void init(){
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(String username){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token).getSubject();
    }

    public boolean validateToken(String token){
        try{
            getClaimsFromToken(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private Claims getClaimsFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenExpired(String token) {
        Date expiration = getClaimsFromToken(token).getExpiration(); // JJWT: exp claim
        return expiration.before(new Date()); // true if expiration date < now
    }

    public long getExpirationMs() {
        return expirationMs;
    }

}
