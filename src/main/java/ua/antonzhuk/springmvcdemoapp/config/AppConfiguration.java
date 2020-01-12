package ua.antonzhuk.springmvcdemoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAO;
import ua.antonzhuk.springmvcdemoapp.dao.NoteDAOImpl;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "ua.antonzhuk.springmvcdemoapp")
@EnableWebMvc
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/notes_db");
        dataSource.setUsername("root");
        dataSource.setPassword("olenenok1009");
        return dataSource;
    }

    @Bean
    public NoteDAO getContactDAO() {
        return new NoteDAOImpl(getDataSource());
    }

}
