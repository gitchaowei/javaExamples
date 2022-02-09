package com.examples.Annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages="com.examples.Annotations")  //comment out this line if keep the body codes
public class BeanAppConfig {

//    @Bean
//    public Samsung getPhone() {
//        return new Samsung();
//    }
//    @Bean  //for another class
//    public MobileProcessor getProcessor(){
//        return new Snapdragon();
//    }
//
// alternatively: add @ComponentScan and delete all @Bean

}
