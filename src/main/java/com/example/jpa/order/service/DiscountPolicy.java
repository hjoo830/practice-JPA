package com.example.jpa.order.service;

import com.example.jpa.member.entity.Member;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DiscountPolicy {

    private static final BigDecimal VIP_RATE = new BigDecimal("0.10");

    public BigDecimal discountAmount(Member member, BigDecimal originalAmount) {
        if (member.getGrade().isVip()) {
            return originalAmount.multiply(VIP_RATE);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal finalAmount(Member member, BigDecimal originalAmount) {
        BigDecimal discount = discountAmount(member, originalAmount);
        BigDecimal result = originalAmount.subtract(discount);

        // 💡 원 단위 반올림이 필요하면 scale 0 사용, 소수 필요하면 이 줄 제거/조정
        return result.setScale(0, RoundingMode.HALF_UP);
    }
}
