package eu.codix.tvtran.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer
{
  public WebSecurityInitializer()
  {
    super(MultiHttpSecurityConfig.class);
  }
}
