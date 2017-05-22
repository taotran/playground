package eu.codix.tvtran.config;

import eu.codix.tvtran.config.auth.CustomAuthenticationProvider;
import eu.codix.tvtran.config.auth.CustomBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/18/2017
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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

  @Bean(name = "myAuthProvider")
  public DaoAuthenticationProvider authProvider()
  {

    CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    return authenticationProvider;
  }

  @Configuration
  @Order(1)
  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter
  {
    private static String REALM = "MY_TEST_REALM";

    @Autowired
    private @Qualifier("myAuthProvider")
    DaoAuthenticationProvider authProvider;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)
    {
      auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
      //@formatter:off
      http
          .antMatcher("/svc/**").authorizeRequests().anyRequest().authenticated()
          .and()
              .httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthenticationEntryPoint())
          .and()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
              .csrf().disable()
      ;
      //@formatter:on
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthenticationEntryPoint()
    {
      return new CustomBasicAuthenticationEntryPoint();
    }
  }

  @Configuration
  public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter
  {
    private final DaoAuthenticationProvider authProvider;

    @Autowired
    public FormLoginWebSecurityConfigurerAdapter(@Qualifier("myAuthProvider")
                                                     DaoAuthenticationProvider authProvider)
    {
      Assert.notNull(authProvider);
      this.authProvider = authProvider;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)
    {
      auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
      //@formatter:off
      http
          .authorizeRequests()
              .anyRequest().authenticated()
      .and()
          .formLogin()
      .and()
          .logout().logoutUrl("/logout")
      .and()
          .csrf().disable()
      ;
      //@formatter:on
    }
  }
}
