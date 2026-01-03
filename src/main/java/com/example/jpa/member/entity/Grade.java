package com.example.jpa.member.entity;

public enum Grade {
    BASIC,
    VIP;

    public boolean isVip() {
        return this == VIP;
    }
}
