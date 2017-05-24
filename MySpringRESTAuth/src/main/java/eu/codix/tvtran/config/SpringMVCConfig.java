package eu.codix.tvtran.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"eu.codix.tvtran.controller", "eu.codix.tvtran.rest"})
public class SpringMVCConfig extends WebMvcConfigurerAdapter
{

  @Bean(name = "viewResolver")
  public ViewResolver viewResolver()
  {
    return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry)
  {
    registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
    registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry)
  {
    super.addViewControllers(registry);
    registry.addViewController("/login.html");
    registry.addViewController("/success.html");
    registry.addViewController("/failure.html");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
  {
    configurer.enable();
  }
}
