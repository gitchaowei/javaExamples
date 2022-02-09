package com.examples.Annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// Spring Core Annotation
// Dependency injection in Maven project
//1. Create a Maven project
//2. POM.XML: add Spring Context
//<dependency>
//  <groupId>org.springframework</groupId>
//  <artifactId>spring-context</artifactId>
//  <version>4.1.9RELEASE</version>
//</dependency>

public class AppAnnotationExample {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanAppConfig.class);
        context.refresh();


        Samsung s7 = (Samsung) context.getBean(Samsung.class);
        // above two line is equivalent to :
        // Samsung s7 = new Samsung();
        s7.phoneConfig();
    }
}
