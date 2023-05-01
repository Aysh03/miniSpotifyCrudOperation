package com.example.trackdata.jwtfilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



















//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;

public class JwtFilter extends GenericFilterBean
{
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        String authheader= request.getHeader("authorization");

        if(authheader==null || !authheader.startsWith("Bearer"))
        {
            throw new ServletException("Token missing ");
        }
       else
       {
           String token=authheader.substring(7);
           Claims claims= Jwts.parser().setSigningKey("mysecretKey").parseClaimsJws(token).getBody();
           request.setAttribute("current_user_emailid",claims.get("user_email"));
           request.setAttribute("s",claims.get("user_email"));
         filterChain.doFilter(request,response);
      }
    }


}
