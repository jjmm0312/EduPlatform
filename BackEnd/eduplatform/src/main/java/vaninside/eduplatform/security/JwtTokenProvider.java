package vaninside.eduplatform.security;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


//@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
// Jwt 토큰 생성 및 유효성 검증
	
	    @Value("spring.jwt.secret")
	    private String jwtSecret;
	    
	    private int jwtExpirationInMs = 6000 * 60 * 60; // 6시간만 토큰 유효
	    UserDetailsService userDetailsService;

	    public String generateToken(Authentication authentication) {
	        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

	        Date now = new Date();
	        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

	        System.out.println(userPrincipal.tokenInfo());
	        
	        return Jwts.builder()
	                .setSubject(userPrincipal.tokenInfo())
	                .setIssuedAt(new Date())
	                .setExpiration(expiryDate)
	                .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                .compact();
	    }

	    public int getUserIdFromJWT(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(jwtSecret)
	                .parseClaimsJws(token)
	                .getBody();

	        return Integer.parseInt(claims.getSubject());
	    }

	    public boolean validateToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	            return true;
	        }catch(Exception e) {
	        	System.out.println("oh no...");
	        }
	            /*
	        } catch (SignatureException ex) {
	            logger.error("Invalid JWT signature");
	        } catch (MalformedJwtException ex) {
	            logger.error("Invalid JWT token");
	        } catch (ExpiredJwtException ex) {
	            logger.error("Expired JWT token");
	        } catch (UnsupportedJwtException ex) {
	            logger.error("Unsupported JWT token");
	        } catch (IllegalArgumentException ex) {
	            logger.error("JWT claims string is empty.");
	        }*/
	        return false;
	    }
	}
	

