package com.example.jpa.order.controller;

import com.example.jpa.order.dto.*;
import com.example.jpa.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/price")
    @Operation(summary = "가격 계산")
    public PriceCalculateResponse calculate(@RequestBody PriceCalculateRequest request) {
        return orderService.calculate(request);
    }

    @PostMapping
    @Operation(summary = "주문 생성")
    public OrderResponse create(@RequestBody OrderCreateRequest request) {
        return orderService.create(request);
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "주문 조회")
    public OrderResponse get(@PathVariable Long orderId) {
        return orderService.get(orderId);
    }
}
