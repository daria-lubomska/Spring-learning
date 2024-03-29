package udemy.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import udemy.spring.util.ViewNames;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "udemy.spring")

public class WebMvcConfig implements WebMvcConfigurer {

  private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/view/";
  private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

  @Bean
  public ViewResolver viewResolver(){
    UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
    viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
    return viewResolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName(ViewNames.HOME);

  }
}
