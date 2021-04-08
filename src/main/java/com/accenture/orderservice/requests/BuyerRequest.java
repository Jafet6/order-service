package com.accenture.orderservice.requests;

import com.accenture.orderservice.domain.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyerRequest {
    private List<ProductOrder> productOrders;

    private Float totalPrice;

    private Long buyerId;
}
