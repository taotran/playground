package eu.codix.tvtran.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
public class WebInitializer implements WebApplicationInitializer
{
  public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException
  {
    final AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
    dispatcherContext.register(SpringMVCConfig.class, AppConfig.class);

    final ServletRegistration.Dynamic servletRegistration =
        servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
    servletRegistration.setLoadOnStartup(1);
    servletRegistration.addMapping("/");
  }
}
