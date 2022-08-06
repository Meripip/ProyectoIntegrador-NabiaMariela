package com.portfolio.MN.Security;

import com.portfolio.MN.Security.Service.UserDetailsImplements;
import com.portfolio.MN.Security.jwt.jwtEntryPoint;
import com.portfolio.MN.Security.jwt.jwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //para bloquear los metodos cuando tenesmos q estar logueados

public class MainSecurity {
    @Autowired
    UserDetailsImplements userDetailsImplements;
    @Autowired
    jwtEntryPoint jwtentryPoint; 
    
     @Bean
    public jwtTokenFilter jwttokenFilter(){
        return new jwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception  {
       return authenticationConfiguration.getAuthenticationManager(); 
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtentryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwttokenFilter(), UsernamePasswordAuthenticationFilter.class);
    
    return http.build();        
    }

    //@Override
    //protected AuthenticationManager authenticationManager() throws Exception {
    //    return super.authenticationManager(); 
    //}

    //@Override
    //public AuthenticationManager authenticationManagerBean() throws Exception {
    //    return super.authenticationManagerBean();
   // }

    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.userDetailsImplements(userDetailsImplements).passwordEncoder(passwordEncoder());
    //}

 
}
