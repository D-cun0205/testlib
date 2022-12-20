package com.spboot.demotest.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUtil {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
