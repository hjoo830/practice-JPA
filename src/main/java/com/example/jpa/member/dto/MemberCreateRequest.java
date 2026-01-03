package com.example.jpa.member.dto;

import com.example.jpa.member.entity.Grade;

public record MemberCreateRequest(
        String name,
        Grade grade) {
}
