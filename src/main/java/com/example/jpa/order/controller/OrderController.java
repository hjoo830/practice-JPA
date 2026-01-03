package com.example.jpa.order.controller;

import com.example.jpa.order.dto.*;
import com.example.jpa.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 가격만 계산 (저장 X)
    @PostMapping("/price")
    public PriceCalculateResponse calculate(@RequestBody PriceCalculateRequest request) {
        return orderService.calculate(request);
    }

    // 주문 생성 (저장 O)
    @PostMapping
    public OrderResponse create(@RequestBody OrderCreateRequest request) {
        return orderService.create(request);
    }

    @GetMapping("/{orderId}")
    public OrderResponse get(@PathVariable Long orderId) {
        return orderService.get(orderId);
    }
}
