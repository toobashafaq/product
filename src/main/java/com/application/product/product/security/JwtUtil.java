package com.application.product.product.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtUtil {
    public String generateToken(String username, List<String> roles){
        return Jwts.b;
    }

}
