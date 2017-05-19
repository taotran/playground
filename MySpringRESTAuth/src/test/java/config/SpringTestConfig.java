package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/15/2017
 */
@Configuration
public class SpringTestConfig
{
  @Autowired
  private WebApplicationContext wac;

  @Autowired
  private
  FilterChainProxy springSecurityFilterChain;

  @Bean(name = "mockMVC")
  public MockMvc mockMvc() {
    return MockMvcBuilders.standaloneSetup(wac).apply(springSecurity(springSecurityFilterChain)).build();
  }
}
