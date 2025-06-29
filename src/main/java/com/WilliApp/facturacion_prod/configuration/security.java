package com.WilliApp.facturacion_prod.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws  Exception{
        httpSecurity.csrf(
                csrf -> csrf.disable()
        ).authorizeHttpRequests(
                auth ->{
                    //auth.anyRequest().authenticated();
                    auth.requestMatchers("/api/v1/productos/**").permitAll()
                            .anyRequest().authenticated(); //Se puede utilizar sin autenticar
                }
        ).httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

}
