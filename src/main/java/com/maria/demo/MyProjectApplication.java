package com.maria.demo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyProjectApplication {

    /*Logging in Spring Boot plays a vital role in Spring Boot applications 
      for recording information, actions, and events within the app. 
      It is also used for monitoring the performance of an application, understanding the behavior of the application,
      and recognizing the issues within the application.*/
    private static final Logger LOG = Logger.getLogger(MyProjectApplication.class.getName());

    public static void main(String[] args) {

        /*
        The ApplicationContext is the central interface within a Spring application 
        that is used for providing configuration information to the application.
        It implements the BeanFactory interface.
        */
         ApplicationContext ctx = SpringApplication.run(MyProjectApplication.class, args);
        String[] names = ctx.getBeanDefinitionNames();
        for (String s : names) {
            LOG.log(Level.INFO, s);
        }
        //SpringApplication.run(MyProjectApplication.class, args);
    }

}
