import config.SpringTestConfig;
import eu.codix.tvtran.config.AppConfig;
import eu.codix.tvtran.config.PersistenceConfig;
import eu.codix.tvtran.config.SecurityConfig;
import eu.codix.tvtran.config.SpringMVCConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  5/15/2017
 */
@WebAppConfiguration
@ContextConfiguration (
    classes = {SecurityConfig.class, SpringTestConfig.class, AppConfig.class, SpringMVCConfig.class, PersistenceConfig.class}
)
public class MyTestBase extends AbstractTestNGSpringContextTests
{
}
