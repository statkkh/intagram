package com.clone.instagram.filter;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import com.clone.instagram.entity.UserEntity;
import com.clone.instagram.provider.JwtProvider;
import com.clone.instagram.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    
    private final UserRepository userRepository; 
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
            try {
                String token = parseBearerToken(request);
                if(token == null){
                    filterChain.doFilter(request, response);
                    return;
                }
                
                String email = jwtProvider.validate(token);
                if(email == null){
                    filterChain.doFilter(request, response);
                    return;
                }
                
                UserEntity userEntity = userRepository.findByEmail(email);
                String role = userEntity.getRole();

                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(role));

                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                AbstractAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(email,  null, null);
                
                securityContext.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(securityContext);                

            } catch (Exception exception) {
                exception.printStackTrace();
            }
    
    }

    private String parseBearerToken(HttpServletRequest request){

        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization = StringUtils.hasText(authorization);
        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;        

        String token = authorization.substring(7);
        return token;
    }
    
    
}
