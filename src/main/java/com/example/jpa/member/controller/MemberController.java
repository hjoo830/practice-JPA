package com.example.jpa.member.controller;

import com.example.jpa.member.dto.MemberCreateRequest;
import com.example.jpa.member.dto.MemberGradeChangeRequest;
import com.example.jpa.member.dto.MemberResponse;
import com.example.jpa.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public MemberResponse create(@RequestBody MemberCreateRequest request) {
        return memberService.create(request);
    }

    @GetMapping("/{memberId}")
    public MemberResponse get(@PathVariable Long memberId) {
        return memberService.get(memberId);
    }

    @PatchMapping("/{memberId}/grade")
    public MemberResponse changeGrade(@PathVariable Long memberId,
                                      @RequestBody MemberGradeChangeRequest request) {
        return memberService.changeGrade(memberId, request);
    }
}
