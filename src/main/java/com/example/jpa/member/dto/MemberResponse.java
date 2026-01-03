package com.example.jpa.member.dto;

import com.example.jpa.member.entity.Grade;

public record MemberResponse(
        Long id,
        String name,
        Grade grade
) {
}
