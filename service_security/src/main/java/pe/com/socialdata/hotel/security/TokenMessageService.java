package pe.com.socialdata.hotel.security;

import static java.util.Collections.emptyList;

import java.io.File;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;


//import com.auth0.jwt.JsonMatcher;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.RSAKeyProvider;

import pe.com.socialdata.hotel.repository.LogContext;

@Service
public class TokenMessageService {
	static final long EXPIRATIONTIME = 864_000_00; // 1 days
    static final String SECRET = "apiSecreto";
  
    static final String HEADER_STRING = "Authorization";
    static RSAPrivateKey privateKey;
    static RSAPublicKey publicKey;
    private static final String PRIVATE_KEY_FILE_RSA = "/security/rsa-private.pem";
	private static final String PUBLIC_KEY_FILE_RSA = "/security/rsa-public.pem";  
    
    public  String addAuthentication( String username) {
    	System.out.println("addAuthentication======INICIO====================================================");
    	String signed="";
    	try {
			privateKey = (RSAPrivateKey) PemUtils.readPrivateKeyFromFile(PRIVATE_KEY_FILE_RSA, "RSA");
			publicKey = (RSAPublicKey) PemUtils.readPublicKeyFromFile(PUBLIC_KEY_FILE_RSA, "RSA");
			signed = JWT.create()
		        		.withSubject(username)
		        		.withKeyId("my-key-id")
		        		.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
		                .sign(Algorithm.RSA256(publicKey, privateKey) 
		               );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
        System.out.println("signed:" + signed);
        System.out.println("addAuthentication======FIN====================================================");
        return signed;
        
    }

    public  boolean getAuthentication(String  token) {
    	System.out.println("getAuthentication======INICIO====================================================");
       
        boolean sw=false;
        RSAKey key;
        if (token != null) {
            // parse the token.
        	
          
        	try {
				key = (RSAKey) PemUtils.readPublicKeyFromFile(PUBLIC_KEY_FILE_RSA, "RSA");
				DecodedJWT jwt = JWT.require(Algorithm.RSA256(key))
						//.withSubject(subject)
		                .build()
		                .verify(token);
				sw=true;
				 System.out.println("getAuthentication======FIN====================================================");
        	}catch (JWTDecodeException   e){
        		sw=false;
    			System.out.println(e.getMessage());
    		
			} catch (IOException e) {
				sw=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
            return sw;
                    
        }
        return sw;
    }
}
