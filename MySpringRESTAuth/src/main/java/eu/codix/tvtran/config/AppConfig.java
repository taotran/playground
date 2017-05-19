package eu.codix.tvtran.config;

import org.springframework.context.annotation.*;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
@Configuration
@EnableAspectJAutoProxy
@PropertySource(value = {"classpath:application.properties"})
@ComponentScan({"eu.codix"})
@Import(PersistenceConfig.class)
public class AppConfig
{

}
