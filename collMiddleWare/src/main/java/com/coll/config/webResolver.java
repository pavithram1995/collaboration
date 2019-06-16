package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.coll")
public class webResolver
{
@Bean
public InternalResourceViewResolver getViewResolver()
{
	System.out.println("---view Resolver Bean  Creation---");
	InternalResourceViewResolver iResolver=new InternalResourceViewResolver();
	iResolver.setPrefix("/WEB-INF/jsp");
	iResolver.setSuffix(".jsp");
	return iResolver;
}
@Bean(name="multipartResolver")
public CommonsMultipartResolver getMultipartResolver()
{
	CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
	multipartResolver.setMaxUploadSize(1000000);
	return multipartResolver;
}
}
