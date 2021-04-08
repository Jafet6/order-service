package com.accenture.orderservice.config;

import com.accenture.orderservice.utils.date.DateUTC;
import com.accenture.orderservice.mappers.OrderMapper;
import com.accenture.orderservice.utils.rest.RestTemplateFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper(new ModelMapper());
    }

    @Bean
    public DateUTC dateUTC() {
        return new DateUTC();
    }

    @Bean
    public RestTemplateFactory restTemplateFactory() {
        return new RestTemplateFactory();
    }
}


