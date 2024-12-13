package org.example;


import com.sun.faces.config.ConfigureListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import javax.faces.webapp.FacesServlet;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class SpringBootPrimeFaceswithJava8 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPrimeFaceswithJava8.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        FacesServlet facesServlet = new FacesServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean<>(facesServlet, "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "nova-light");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }
}
