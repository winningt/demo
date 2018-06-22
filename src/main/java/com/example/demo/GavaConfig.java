package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by import com.google.common.collect.ImmutableListMultimap;
 on 18-6-11.
 */
@Configuration
public class GavaConfig {

    @Bean
    public GavaDao getCache(){
        return new GavaDao();
    }

}
