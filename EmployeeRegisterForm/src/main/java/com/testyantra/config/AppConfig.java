package com.testyantra.config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.testyantra.init.SecurityInit;
import com.testyantra.model.Employee;
import com.testyantra.model.LoginPage;

@Configuration // Java Config File
 @EnableWebMvc  // make this as web application
 @EnableTransactionManagement // enable commit/rollback
 @ComponentScan(basePackages="com.testyantra") //all files are created under this folder only
 //@PropertySource("classpath:app.properties") //load properties file from src/main/resource folder
@PropertySource("classpath:jdbc.properties")//jdbc properties
@Import({SecurityConfig.class,SecurityInit.class})
 public class AppConfig {

	 //load properties into AppConfig
	 @Autowired
	 private Environment env;

	 
	 //1. DataSource Bean
	 @Bean  //=> @Bean creating Object
	 public BasicDataSource dsObj() {
		 BasicDataSource ds=new BasicDataSource();
		 ds.setDriverClassName(env.getProperty("dc"));
		 ds.setUrl(env.getProperty("url"));
		 ds.setUsername(env.getProperty("un"));
		 ds.setPassword(env.getProperty("pwd"));

		 ds.setInitialSize(5);
		 ds.setMaxIdle(5);
		 ds.setMinIdle(3);
		 ds.setMaxTotal(5);
		 return ds;
	 }

	 //2. SessionFactory Bean
	 @Bean  //=> creating Object
	 public LocalSessionFactoryBean sfObj() {
		 LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		 sf.setDataSource(dsObj());
		 sf.setAnnotatedClasses(Employee.class,LoginPage.class);
		 return sf;
	 }
	

	 //4. HibernateTxManager Bean
	 @Bean
	 public HibernateTransactionManager htxm() {
		 HibernateTransactionManager htm=new HibernateTransactionManager();
		 htm.setSessionFactory(sfObj().getObject());
		 return htm;
	 }


	 //5. ViewResolver Bean
	 @Bean
	 public InternalResourceViewResolver ivr() {
		 InternalResourceViewResolver vr=new InternalResourceViewResolver();
		 vr.setPrefix(env.getProperty("mvc.prefix"));
		 vr.setSuffix(env.getProperty("mvc.suffix"));
		 return vr;
	 }
	 
	 @Bean
	 public JdbcTemplate jtObj()
	 {
		 JdbcTemplate jt=new JdbcTemplate();
		 jt.setDataSource(dsObj());
		
		 return jt;
	 }
	 

	 
 }





