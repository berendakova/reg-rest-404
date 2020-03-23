package ru.kpfu.springcontrollers.config;

import org.jtwig.spring.JtwigViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("ru.kpfu.springcontrollers.controllers")
@EnableWebMvc
public class Config implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setRedirectContextRelative(false);
        return resolver;
    }

    @Bean
    public ViewResolver twigViewResolver() {
        JtwigViewResolver resolver = new JtwigViewResolver();
        resolver.setPrefix("/WEB-INF/twig/");
        resolver.setSuffix(".html.twig");
        resolver.setRedirectContextRelative(false);
        resolver.setOrder(0);
        return resolver;
    }

    @Bean
    public ViewResolver errorResolver(){
        ErrorResolver resolver = new ErrorResolver();
        resolver.setPrefix("/WEB-INF/jsp/errors");
        resolver.setSuffix(".jsp");
        resolver.setRedirectContextRelative(false);
        resolver.setOrder(1);
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("tests");
    }
}
