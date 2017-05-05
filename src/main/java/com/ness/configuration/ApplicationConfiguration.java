
package com.ness.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Maruf
 */

@Configuration 
@ComponentScan("com.ness") 
@EnableWebMvc
public class ApplicationConfiguration extends WebMvcConfigurerAdapter{
    @Bean  
    public InternalResourceViewResolver viewResolver() {  
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/");  
        resolver.setSuffix(".jsp");
        return resolver;  
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
   
        registry.addResourceHandler("/**").addResourceLocations("/");
    } 
}
