package com.codecool.elproyectegrande.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class BearerTokenAuthenticatingFilter extends OncePerRequestFilter {

    private static final String SERVICE_TOKEN = System.getProperty("user.srv.token", "MY-TOKEN");

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer: " + SERVICE_TOKEN)) {
            // Token is valid, let the request pass through the filter chain

            // Add the desired role to the user's authentication token
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("USER");
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("", "", List.of(authority));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            filterChain.doFilter(request, response);
        }
            // Token is missing or invalid, but allow the request to proceed as permitAll()
            filterChain.doFilter(request, response);

    }
}