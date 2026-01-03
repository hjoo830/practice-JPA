package com.example.jpa.order.dto;

import java.math.BigDecimal;

public record PriceCalculateRequest(
        Long memberId,
        BigDecimal originalAmount
) {}
