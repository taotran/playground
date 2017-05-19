package eu.codix.tvtran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Property of CODIX Bulgaria EAD
 * Created by tvtran
 * Date:  4/6/2017
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"eu.codix.tvtran.repository"})
public class PersistenceConfig
{
  //@formatter:off
  private static final String BEAN_BASE_PACKAGE         = "eu.codix.tvtran.bean"          ;

  private static final String HIBERNATE_DIALECT         = "hibernate.dialect"             ;
  private static final String HIBERNATE_FORMAT_SQL      = "hibernate.format_sql"          ;
  private static final String HIBERNATE_HBM2DDL_AUTO    = "hibernate.hbm2ddl.auto"        ;
  private static final String HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy" ;
  private static final String HIBERNATE_SHOW_SQL        = "hibernate.show_sql"            ;

  private static final String JDBC_DRIVER               = "jdbc.driver"                   ;
  private static final String JDBC_URL                  = "jdbc.url"                      ;
  private static final String JDBC_USER                 = "jdbc.user"                     ;
  private static final String JDBC_PASSWORD             = "jdbc.password"                 ;
  //@formatter:on

  @Autowired
  private Environment env;

  @Bean
  public DataSource dataSource()
  {
    //@formatter:off
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName (env.getProperty(JDBC_DRIVER));
    dataSource.setUrl             (env.getProperty(JDBC_URL));
    dataSource.setUsername        (env.getProperty(JDBC_USER));
    dataSource.setPassword        (env.getProperty(JDBC_PASSWORD));
    return dataSource;
  }

  @Bean
  public EntityManager entityManager() {
    return entityManagerFactoryBean().createEntityManager();
  }

  @Bean
  public PlatformTransactionManager transactionManager()
  {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactoryBean());
    transactionManager.setDataSource(dataSource());
    return transactionManager;
  }

  @Bean(name = "entityManagerFactory")
  public EntityManagerFactory entityManagerFactoryBean()
  {
    final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setShowSql(true);
    hibernateJpaVendorAdapter.setGenerateDdl(true);

    final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

    factoryBean.setPackagesToScan(BEAN_BASE_PACKAGE);
    factoryBean.setDataSource(dataSource());
    factoryBean.setJpaDialect(jpaDialect());
    factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

    final Properties properties = new Properties();

    //@formatter:off
    properties.put(HIBERNATE_DIALECT      , env.getProperty(HIBERNATE_DIALECT     ));
    properties.put(HIBERNATE_FORMAT_SQL   , env.getProperty(HIBERNATE_FORMAT_SQL  ));
    properties.put(HIBERNATE_HBM2DDL_AUTO , env.getProperty(HIBERNATE_HBM2DDL_AUTO));
    properties.put(HIBERNATE_SHOW_SQL     , env.getProperty(HIBERNATE_SHOW_SQL    ));
    //@formatter:on

    factoryBean.setJpaProperties(properties);
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  /**
   * @return {@link JpaDialect}
   */
  @Bean
  public JpaDialect jpaDialect()
  {
    return new HibernateJpaDialect();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

}
