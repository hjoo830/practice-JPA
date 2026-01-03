package com.example.jpa.order.dto;

import java.math.BigDecimal;

public record OrderCreateRequest(
        Long memberId,
        BigDecimal originalAmount
) {}
