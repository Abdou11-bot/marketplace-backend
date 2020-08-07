package com.project.marketplace;

import com.project.marketplace.entity.ImageStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableConfigurationProperties({ImageStorageProperties.class})
public class MarketplaceApplication  implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MarketplaceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }
//    public static void main(String[] args) {
//        SpringApplication.run(MarketplaceApplication.class, args);
//    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedOrigins(List.of("*"));
        config.setAllowCredentials(true);
        if(config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()){
            source.registerCorsConfiguration("/api/**",config);
        }
        return new CorsFilter(source);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

}
