package com.baseauth.server.filter;

import java.util.Date;
import java.util.Map;

import com.baseauth.server.model.Developer;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtProvider {
    private static final String TOKEN_SECRET = "my-super-secret-key";

    public String generateToken(Developer developer) {
        return Jwts.builder()
            .setSubject(developer.getLogin())
            .setExpiration(new Date(new Date().getTime() + 600000L))
            .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
            .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");
        } catch (SignatureException sEx) {
            log.error("Invalid signature");
        } catch (Exception e) {
            log.error("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

}
