package com.example.demo;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "tokenfilter")
public class UserIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MutableHttpServletRequest newrequest = new MutableHttpServletRequest(request);
        System.out.printf("filter running");
        newrequest.putHeader("userid","dddddddddddd");
        filterChain.doFilter(newrequest,response);
    }
}


