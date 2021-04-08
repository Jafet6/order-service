package com.accenture.orderservice.controllers;

import com.accenture.orderservice.domain.Order;
import com.accenture.orderservice.mappers.OrderMapper;
import com.accenture.orderservice.requests.BuyerRequest;
import com.accenture.orderservice.responses.MessageResponse;
import com.accenture.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody BuyerRequest buyerRequest) throws ParseException {
        Order orderDomain = orderMapper.convertBuyerRequestRequestToEntity(buyerRequest);
        MessageResponse serviceResponse = orderService.create(orderDomain);
        return ResponseEntity.status(HttpStatus.OK).body(serviceResponse);
    }

}
