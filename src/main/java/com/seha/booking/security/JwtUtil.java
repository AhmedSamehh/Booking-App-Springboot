package com.seha.booking.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "X3PKgWW8lOamgJInaDsZhQu3m4VjAVCKx+1uPiDLIFMxwRY2jt42NJkMd6u4mA7VNKJ5iUQ3Grg9oIdLgedhLy3IoZB+IbggNBVsHaxjotF5f+fSm5NSKVm4yBuYMe/Kj71/AxlUN+rUh5tsoKpCnpDGVmhtg2OrBzbJncSchuEKsUoipmEYNsUAPsk/e0y02J8eQGMfoJKWoSlrHGIh00GKp7bySirbOMj+XVV3gPVwMGXNIirUnNS4tB6wqijqjI7awQcYDFXusu2rL+pQWmXKBJqEriDKSbM7ik/BciKdnnu5KaTBhxWcNuL8fvvj5bReYVXK5xBpPZCbY7RW";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Corrected key usage
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}