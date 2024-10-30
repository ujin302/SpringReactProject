package spring.conf;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:spring/db.properties")  
@MapperScan("*.dao")
public class SpringConfiguration {

   private @Value("${jdbc.driver}") String driver;
   private @Value("${jdbc.url}") String url;
   private @Value("${jdbc.username}") String username;
   private @Value("${jdbc.password}") String password;
   
   @Autowired
   private ApplicationContext context;
   
   @Bean
   public BasicDataSource dataSource() {
      BasicDataSource basicDataSource =  new BasicDataSource();
      basicDataSource.setDriverClassName(driver);
      basicDataSource.setUrl(url);
      basicDataSource.setUsername(username);
      basicDataSource.setPassword(password);
      return basicDataSource;
   }
   
   @Bean
   public SqlSessionFactory sqlSessionFactory() throws Exception {
      // MyBatis의 SqlSessionFactory 설정
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      sqlSessionFactoryBean.setDataSource(dataSource());
      sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));

      sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/*Mapper.xml"));

      sqlSessionFactoryBean.setTypeAliasesPackage("*.bean");
      
      return sqlSessionFactoryBean.getObject();
   }
   
   @Bean
   public SqlSessionTemplate sqlSession() throws Exception {
      SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
      return sqlSessionTemplate;
   }
   
   @Bean
   public DataSourceTransactionManager transactionManager(){
      DataSourceTransactionManager dataSourceTransactionManager = 
            new DataSourceTransactionManager(dataSource());
      return dataSourceTransactionManager;
   }
   
   @PostConstruct
   public void init() {
       System.setProperty("https.protocols", "TLSv1.2");
   }
}