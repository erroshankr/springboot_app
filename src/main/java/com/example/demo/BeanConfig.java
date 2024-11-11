package com.example.demo;

import com.example.demo.beans.IceCream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // --> loads the configuration during application startup
public class BeanConfig {

   /* @Bean   //  bean initialization -->  server startup time
    public IceCream iceCream() {
        IceCream i1 = new IceCream(123,"xyz","red","strawberry", 150);
        *//*i1.setName("abc");
        i1.setPrice(500);
        i1.setColor("cream");
        i1.setFlavour("Vanilla");*//*
        return i1;
    }*/
}
