package com.demosecurity.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;

    public static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String jwt = getTokenFromRequest(request);
            if (jwt != null && jwtProvider.isValidToken(jwt)){
                String username = jwtProvider.getUsernameFromToken(jwt);

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken();
            }

        } catch (Exception e){
            logger.error("Failed -> UnAuthenticated");
        }

    }

    private String getTokenFromRequest(HttpServletRequest request){
        String header = request.getHeader("Authentication");
        if (header != null && header.startsWith("Bearer ")){
            return header.substring(7);
        }
        return null;
    }
}
