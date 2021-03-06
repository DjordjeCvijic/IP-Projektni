package com.ipproject.WebMuseums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableScheduling
public class WebMuseumsApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebMuseumsApplication.class, args);
	}
	
	  @Configuration
	    public class SpringFoxConfig {
	        @Bean
	        public Docket api() {
	            return new Docket(DocumentationType.SWAGGER_2)
	                    .select()
	                    .apis(RequestHandlerSelectors.any())
	                    .paths(PathSelectors.any())
	                    .build();
	        }
	    }
	  
//	   @Bean
//	    public WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurerAdapter() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/**");
//	            }
//	        };
//	    }
//	   
	   @Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}

}
