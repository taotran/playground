package eu.codix.tvtran.config.auth;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint
{

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException
  {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.addHeader("WWW-Authenticate", "Basic Realm=" + getRealmName() + "");
    response.addHeader("TVTran", "Test____");
    PrintWriter writer = response.getWriter();
    writer.println("HTTP Status 401 : " + authException.getMessage());
  }

  @Override
  public void afterPropertiesSet() throws Exception
  {
    setRealmName("MY_TEST_REALM");
    super.afterPropertiesSet();
  }
}
