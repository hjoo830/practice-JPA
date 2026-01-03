package com.example.jpa.order.service;

import com.example.jpa.order.dto.*;

public interface OrderService {
    PriceCalculateResponse calculate(PriceCalculateRequest request);
    OrderResponse create(OrderCreateRequest request);
    OrderResponse get(Long orderId);
}
