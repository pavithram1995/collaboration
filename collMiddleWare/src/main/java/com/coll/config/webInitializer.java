package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class webInitializer extends  AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		System.out.println("---getRootConfigClasses() method---");
		return new Class[] {webResolver.class,DBConfig.class};
	}
	

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		System.out.println("---getServletConfigClasses() method---");
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		System.out.println("---getServletMappings() method---");
		return new String[] {"/"};
	}

	

}
