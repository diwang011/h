package com.example.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
@WebFilter(urlPatterns = "/cors")
public class CorsFilter extends OncePerRequestFilter
{
    //private final static String ALLOWORIGIN_CORS_A = "http://localhost:4200";
    //private final static String ALLOWORIGIN_CORS_b = "http://localhost:3000";
    @Autowired ConnectionSettings conn;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        // Access-Control-Allow-Origin: 指定授权访问的域
        response.addHeader("Access-Control-Allow-Origin", conn.getAlloworigin_cors_a()); // 此优先级高于@CrossOrigin配置

        // Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

        response.addHeader("Access-Control-Allow-Headers", "Content-Type");

        response.addHeader("Access-Control-Max-Age", "1800");// 30 min
        filterChain.doFilter(request, response);
    }
}