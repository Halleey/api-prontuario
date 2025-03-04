package com.api.prontuario.config.jwt;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    public String extractUsername(String token) {
        log.info("🔍 Extraindo usuário do token...");
        return getClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            log.info("✅ Validando token...");
            getClaims(token);
            log.info("✅ Token válido!");
            return true;
        } catch (ExpiredJwtException e) {
            log.error("❌ Erro: Token expirado!");
        } catch (UnsupportedJwtException e) {
            log.error("❌ Erro: Token com formato inválido!");
        } catch (MalformedJwtException e) {
            log.error("❌ Erro: Token malformado!");
        } catch (SignatureException e) {
            log.error("❌ Erro: Assinatura inválida!");
        } catch (JwtException e) {
            log.error("❌ Erro desconhecido ao validar token: {}", e.getMessage());
        }
        return false;
    }

    public Claims getClaims(String token) {
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractRole(String token) {
        log.info("🔍 Extraindo role do token...");
        return getClaims(token).get("role", String.class);
    }
}

