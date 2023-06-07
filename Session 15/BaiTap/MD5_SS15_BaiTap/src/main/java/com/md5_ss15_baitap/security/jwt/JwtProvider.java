package com.md5_ss15_baitap.security.jwt;

import com.md5_ss15_baitap.security.userPrinciple.UserPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
//    tạo key secret của Jwt
    private String jwtSecret = "nhantic1998";
    private int jwtExpiration = 86400;

    /**
     * Tạo token
     * lấy ra userPrinciple từ authentication
     * @param authentication
     * @return Jwts.setSubject
     */
    public String createToken(Authentication authentication) {
        // lấy ra tất cả user hiện tại trên hệ thống
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        // set up token (subject, thời điểm tạo, thời gian sống, đăng kí key mở khoá (signWith) và đóng gói lại
        return Jwts.builder().setSubject(userPrinciple.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Validate Token
     * @param token
     * @return true / false
     */
    public boolean validateToken(String token) {
        try {
            // mở khoá token (__Jwts.parser().setSigningKey(jwtSecret)__) .parseClaims để lấy ra token
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
            // nếu hợp lệ return true
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid Jwt Signature -> Message {}", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid Formate Token -> Message {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired Jwt Token -> Message {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported Jwt Token -> Message {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("Jwt Claims String empty -> Message {}", e);
        }
        // không thì false
        return false;
    }

    public String getEmailFromToken(String token) {
        String email = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody().getSubject();
        return email;
    }
}
