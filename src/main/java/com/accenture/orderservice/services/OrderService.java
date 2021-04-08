package com.accenture.orderservice.services;

import com.accenture.orderservice.domain.Order;
import com.accenture.orderservice.domain.ProductOrder;
import com.accenture.orderservice.repository.OrderRepository;
import com.accenture.orderservice.repository.ProductOrderRepository;
import com.accenture.orderservice.responses.MessageResponse;
import com.accenture.orderservice.utils.date.DateUTC;
import com.accenture.orderservice.utils.rest.RestTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    RestTemplateFactory restTemplateFactory;

    @Autowired
    DateUTC dateUTC;

    @Transactional
    public MessageResponse create(Order order) throws ParseException {

        Date orderDate = dateUTC.getCurrentUtcTime();
        order.setPurchaseDate(orderDate);

        order = orderRepository.save(order);

        for (ProductOrder element: order.getProductOrders()) {
            element.setOrders(order);
        }


        MessageResponse response = new MessageResponse("Compra realizada com sucesso!");
        return response;
    }
}
