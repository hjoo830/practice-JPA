package com.example.jpa.order.service;

import com.example.jpa.member.dao.MemberRepository;
import com.example.jpa.member.entity.Member;
import com.example.jpa.order.dao.OrderRepository;
import com.example.jpa.order.dto.*;
import com.example.jpa.order.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository,
                            OrderRepository orderRepository,
                            DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    @Transactional(readOnly = true)
    public PriceCalculateResponse calculate(PriceCalculateRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("member not found: " + request.memberId()));

        BigDecimal original = request.originalAmount();
        BigDecimal discount = discountPolicy.discountAmount(member, original);
        BigDecimal fin = discountPolicy.finalAmount(member, original);

        // finalAmount()에서 반올림하면 discount가 원본-최종으로 약간 달라질 수 있으니 보정
        BigDecimal normalizedDiscount = original.subtract(fin);

        return new PriceCalculateResponse(member.getId(), member.getGrade(), original, normalizedDiscount, fin);
    }

    @Override
    @Transactional
    public OrderResponse create(OrderCreateRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("member not found: " + request.memberId()));

        BigDecimal original = request.originalAmount();
        BigDecimal fin = discountPolicy.finalAmount(member, original);
        BigDecimal discount = original.subtract(fin);

        Order saved = orderRepository.save(new Order(member, original, discount, fin));

        return new OrderResponse(
                saved.getId(),
                saved.getMember().getId(),
                saved.getOriginalAmount(),
                saved.getDiscountAmount(),
                saved.getFinalAmount(),
                saved.getCreatedAt()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse get(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("order not found: " + orderId));

        return new OrderResponse(
                order.getId(),
                order.getMember().getId(),
                order.getOriginalAmount(),
                order.getDiscountAmount(),
                order.getFinalAmount(),
                order.getCreatedAt()
        );
    }
}
