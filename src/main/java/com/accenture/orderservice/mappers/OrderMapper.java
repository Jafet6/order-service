package com.accenture.orderservice.mappers;

import com.accenture.orderservice.domain.Order;
import com.accenture.orderservice.requests.BuyerRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;

public class OrderMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Order convertBuyerRequestRequestToEntity(BuyerRequest buyerRequest) throws ParseException {
        Order buyerDomain = modelMapper.map(buyerRequest, Order.class);
        return buyerDomain;
    }

}
