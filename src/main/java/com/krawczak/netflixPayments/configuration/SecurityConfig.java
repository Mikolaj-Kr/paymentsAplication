package com.krawczak.netflixPayments.configuration;

import javax.sql.DataSource;
import org.hibernate.dialect.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private DataSource dataSource;

  @Value("${spring.queries.users-query")
  private String usersQuery;

  @Value("${spring.queries.roles-query")
  private String rolesQuery;

  @Bean
  public UserDetailsService userDetailsService(){
    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("mikolaj")
        .password("mikolaj25")
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.jdbcAuthentication()
        .usersByUsernameQuery(usersQuery)
        .authoritiesByUsernameQuery(rolesQuery)
        .dataSource(dataSource)
        .passwordEncoder(bCryptPasswordEncoder);
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/pay-main-admin")
        .hasRole("ADMIN")
    .and()
    .formLogin()
        .permitAll()
    .defaultSuccessUrl("/pay-main")
    .and();
  }
}
