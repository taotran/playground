package eu.codix.tvtran.config;

import org.apache.log4j.LogManager;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/7/2017
 */
public class TestFilter
{

  private static final org.apache.log4j.Logger logger = LogManager.getLogger(TestFilter.class);

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
    logger.info("Inside testFilter filter");
    chain.doFilter(request, response);
  }

}
