package com.example.jpa.member.service;

import com.example.jpa.member.dao.MemberRepository;
import com.example.jpa.member.dto.MemberCreateRequest;
import com.example.jpa.member.dto.MemberGradeChangeRequest;
import com.example.jpa.member.dto.MemberResponse;
import com.example.jpa.member.entity.Grade;
import com.example.jpa.member.entity.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public MemberResponse create(MemberCreateRequest request) {
        Grade grade = request.grade() == null ? Grade.BASIC : request.grade();
        Member saved = memberRepository.save(new Member(request.name(), grade));
        return new MemberResponse(saved.getId(), saved.getName(), saved.getGrade());
    }

    @Override
    @Transactional(readOnly = true)
    public MemberResponse get(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("member not found: " + memberId));
        return new MemberResponse(member.getId(), member.getName(), member.getGrade());
    }

    @Override
    @Transactional
    public MemberResponse changeGrade(Long memberId, MemberGradeChangeRequest request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("member not found: " + memberId));
        member.changeGrade(request.grade());
        return new MemberResponse(member.getId(), member.getName(), member.getGrade());
    }
}
