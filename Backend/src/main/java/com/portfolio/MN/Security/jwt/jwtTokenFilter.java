//valida el token nuevamente(usando el provider)se ejecuta cda vez q querramos hacer algo, sino nos pide login
package com.portfolio.MN.Security.jwt;

import com.portfolio.MN.Security.Service.UserDetailsImplements;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


public class jwtTokenFilter extends OncePerRequestFilter{
       private final static Logger logger = LoggerFactory.getLogger(jwtProvider.class);
       
       @Autowired
       jwtProvider jwtprovider;
       @Autowired
       UserDetailsImplements userDetailsImplements;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       try{
           String token = getToken(request);
           if(token != null && jwtprovider.validateToken(token)){
               String nombreUsuario = jwtprovider.getNombreUsuarioFromToken(token);
               UserDetails userDetails = userDetailsImplements.loadUserByUsername(nombreUsuario);
               UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(userDetails,
               null, userDetails.getAuthorities());
               SecurityContextHolder.getContext().setAuthentication(userAuth);
           }
       }catch(Exception e){
           logger.error("Falló el metodo doFilterInternal");
       }
       filterChain.doFilter(request, response);
    }
    
    //crear clase getToken de arriba
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer"))
            return header.replace("Bearer", "");
        return null;
    }
    
    
    
    
    
}
