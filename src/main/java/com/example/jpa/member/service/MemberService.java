package com.example.jpa.member.service;

import com.example.jpa.member.dto.MemberCreateRequest;
import com.example.jpa.member.dto.MemberGradeChangeRequest;
import com.example.jpa.member.dto.MemberResponse;

public interface MemberService {
    MemberResponse create(MemberCreateRequest request);
    MemberResponse get(Long memberId);
    MemberResponse changeGrade(Long memberId, MemberGradeChangeRequest request);
}
