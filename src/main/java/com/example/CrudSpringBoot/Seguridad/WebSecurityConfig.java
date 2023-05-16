package com.example.CrudSpringBoot.Seguridad;

import com.example.CrudSpringBoot.Entity.Usuario;
import com.example.CrudSpringBoot.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Encriptar ciudad de nuestra pagina
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Guardar usuarios en memoria, indicando quien es usuario y admin
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails usuario1= User.withUsername("jhon")
                .password("$2a$10$vFC1FDtBtswlc2AFEqPtP.IX7B236qFzQST9/No49zrFVozCIb8C.")
                .roles("USER")
                .build();

        UserDetails usuario2= User.withUsername("admin")
                .password("$2a$10$vFC1FDtBtswlc2AFEqPtP.IX7B236qFzQST9/No49zrFVozCIb8C.")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(usuario1,usuario2);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/form").permitAll()
                .antMatchers("/formd").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/Restaurantes").permitAll()
                .antMatchers("/Restaurante1").permitAll()
                .antMatchers("/Restaurante2").permitAll()
                .antMatchers("/Restaurante3").permitAll()
                .antMatchers("/Restaurante4").permitAll()
                .antMatchers("/Restaurante5").permitAll()
                .antMatchers("/formd").permitAll()
                .antMatchers("/eliminar/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll();

    }
}
