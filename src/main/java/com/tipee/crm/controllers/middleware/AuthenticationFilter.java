package com.tipee.crm.controllers.middleware;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tipee.crm.controllers.exception.AccessTokenParser;
import com.tipee.crm.controllers.exception.HttpRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;

public class AuthenticationFilter implements Filter{
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("########## Initiating Authentication filter ##########");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        LOGGER.info("Logging Request  {} : {}", request.getMethod(), request.getRequestURI());
        
        String accessToken = request.getHeader("Authorization");
        if (accessToken.trim() == "")
            throw new HttpRequestException();
        if (!accessToken.startsWith("Bearer ")) {
            throw new HttpRequestException();
        }
        Claims claims = AccessTokenParser.getClaims(accessToken);

        if (Objects.isNull(claims))
        throw new HttpRequestException();
      
        //String userId = claims.get("sub", String.class);
        chain.doFilter(request, response);

        LOGGER.info("Logging Response :{}", response.getContentType());
        
    }

    @Override
    public void destroy() {
       
    }
}
