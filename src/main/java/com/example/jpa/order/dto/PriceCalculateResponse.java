package com.example.jpa.order.dto;

import com.example.jpa.member.entity.Grade;

import java.math.BigDecimal;

public record PriceCalculateResponse(
        Long memberId,
        Grade grade,
        BigDecimal originalAmount,
        BigDecimal discountAmount,
        BigDecimal finalAmount
) {}
