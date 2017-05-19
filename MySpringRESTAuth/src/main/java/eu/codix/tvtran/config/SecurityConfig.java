//package eu.codix.tvtran.config;
//
//import eu.codix.tvtran.config.auth.CustomAuthenticationProvider;
//import eu.codix.tvtran.config.auth.CustomBasicAuthenticationEntryPoint;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
///**
// * Property of CODIX Bulgaria EAD
// * Created by tvtran
// * Date:  4/6/2017
// */
//@Configuration
//@EnableWebSecurity
//@ComponentScan(basePackages = {
//    "eu.codix"})
//public class SecurityConfig extends WebSecurityConfigurerAdapter
//{
//
//  private static String REALM = "MY_TEST_REALM";
//
//  @Autowired
//  private @Qualifier("authenticationService")
//  UserDetailsService authService;
//
//  @Autowired
//  public void configure(AuthenticationManagerBuilder auth) throws Exception
//  {
//    auth.authenticationProvider(authProvider());
//  }
//
//  @Override
//  public void configure(WebSecurity web) throws Exception
//  {
//    web.ignoring().antMatchers("/resources/**");
//    web.debug(true);
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception
//  {
//    //@formatter:off
//    http
//        .authorizeRequests()
//        .antMatchers("/login.html").permitAll()
//        .antMatchers("/svc/**").hasAuthority("READ_USER")
//        .anyRequest()
//          .authenticated()
//        .and()
//          .httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthenticationEntryPoint())
//        .and()
//          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//          .formLogin()
//            .failureForwardUrl("/failure.html")
//            .successForwardUrl("/index")
//          .permitAll(true)
//        .and()
//          .csrf().disable()
//    //@formatter:on
//    ;
//  }
//
//  @Bean
//  public CustomBasicAuthenticationEntryPoint getBasicAuthenticationEntryPoint()
//  {
//    return new CustomBasicAuthenticationEntryPoint();
//  }
//
//  @Override
//  protected UserDetailsService userDetailsService()
//  {
//    return authService;
//  }
//
//  @Bean
//  public DaoAuthenticationProvider authProvider()
//  {
//    CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();
//    authenticationProvider.setUserDetailsService(userDetailsService());
//    return authenticationProvider;
//  }
//
//  @Bean(name = "testFilter")
//  public TestFilter testFilter()
//  {
//    return new TestFilter();
//  }
//}
