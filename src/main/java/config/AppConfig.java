package config;

import model.Student;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import service.StudentService;

import java.util.Properties;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Configuration
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig {

	@Bean
	public Student student() {
		return new Student();
	}
	


    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        Properties properties = new Properties();
        //For Postgresql
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        //For mysql
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.hbm2ddl.auto", "update");

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setPackagesToScan("model");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Assignment2");
        dataSource.setUsername("postgres");
        dataSource.setPassword("thanhminh");

        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setHibernateProperties(properties);

        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager tx = new HibernateTransactionManager(sessionFactory);

        return tx;
    }

}