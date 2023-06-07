package com.demosecurity.security.jwt;

import com.demosecurity.security.userPrincipal.UserPrincipal;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.net.Authenticator;
import java.util.Date;

@Component
public class JwtProvider {
    // Chua cac phuong thuc de thao tac voi jwt

    private final String secretKey = "nguyen.trong.nhan"; // this is SIGNATURE
    private final int jwtExpiration = 86400;
    public static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    //-> systemOut --> in ra duoc vi tri bi sai, tai class nao --> vao thoi diem nao

    /**
     *
     * @param authentication
     * Khi ma xac thuc thi security se tao ra mot doi tuong Authentication
     * --> trong authentication --> UserPrincipal
     * @return Token
     */
    public String generatorToken(Authentication authentication){

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal(); //--> return UserDetail
        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000L))
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("Token expired Message {}", e.getMessage());
        }catch (UnsupportedJwtException e) {
            logger.error("Token unsupported Message {}", e.getMessage());
        }catch (MalformedJwtException e) {
            logger.error("Error format token Message {}", e.getMessage());
        }catch (SignatureException e) {
            logger.error("Error signature token Message {}", e.getMessage());
        }catch (IllegalArgumentException e) {
            logger.error("Claims empty Token Message {}", e.getMessage());
        }
        return false;
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().getSubject();
    }

}
