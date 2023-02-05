package com.kniet.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//this config class we use is configuration for all requests from the client
public class WebInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        // TODO Auto-generated method stub
        return null;
    }

    //it handles our config class
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        // TODO Auto-generated method stub
        return new Class[] { AppConfig.class };
    }

    //receive all the request
    @Override
    protected String[] getServletMappings()
    {
        // TODO Auto-generated method stub
        return new String[] { "/" };
    }
}
