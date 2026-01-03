package com.example.jpa.order.entity;

import com.example.jpa.member.entity.Member;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal originalAmount;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal discountAmount;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal finalAmount;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected Order() {}

    public Order(Member member,
                 BigDecimal originalAmount,
                 BigDecimal discountAmount,
                 BigDecimal finalAmount) {
        this.member = member;
        this.originalAmount = originalAmount;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Member getMember() { return member; }
    public BigDecimal getOriginalAmount() { return originalAmount; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public BigDecimal getFinalAmount() { return finalAmount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
