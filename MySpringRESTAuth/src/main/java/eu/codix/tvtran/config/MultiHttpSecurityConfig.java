package eu.codix.tvtran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/18/2017
 */
@EnableWebSecurity
@ComponentScan(basePackages = "eu.codix")
public class MultiHttpSecurityConfig
{
  @Autowired
  private @Qualifier("authenticationService")
  UserDetailsService authService;

  @Bean
  public UserDetailsService userDetailsService()
  {
    return authService;
  }

  @Configuration
  @Order(1)
  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter
  {
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
      //@formatter:off
      http
          .antMatcher("/svc/**")
          .authorizeRequests()
              .anyRequest().hasAnyRole("USER", "ADMIN")
              .and()
          .httpBasic();
      //@formatter:on
    }
  }

  @Configuration
  public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
  {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
      //@formatter:off
      http
          .authorizeRequests()
              .anyRequest().authenticated()
              .and()
          .formLogin();
      //@formatter:on
    }
  }
}
