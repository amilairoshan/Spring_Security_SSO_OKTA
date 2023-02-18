package com.auth0.config;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//import com.auth0.AuthenticationController;
//import com.auth0.jwk.JwkProvider;
//import com.auth0.jwk.JwkProviderBuilder;

import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import org.springframework.security.oauth2.jwt.Jwt;


/**
 * @author AMILA
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
    private String issuer=""; //provide issuer url
    private String audience=""; //provide audience
	
   private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }
    
   

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               // allow all users to access the home pages and the static images directory
               .mvcMatchers("/","/login", "/images/**").permitAll()
               //allow authentication for exposed rest end point
               .mvcMatchers("/api/cartDetails").authenticated()
               // all other requests must be authenticated
               .anyRequest().authenticated()
               // set the login success url
               .and().oauth2Login().defaultSuccessUrl("/home", true)
               .and().logout()
               // handle logout requests at /logout path
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
               // customize logout handler to log out of Auth0
               .addLogoutHandler(logoutHandler)
               
               .and().cors()
               .and().oauth2ResourceServer().jwt();
               
               
    }
    
  
    @Bean
    JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
                JwtDecoders.fromOidcIssuerLocation(issuer);

        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator(audience);
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuer);
        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);

        jwtDecoder.setJwtValidator(withAudience);

        return jwtDecoder;
    }
}
