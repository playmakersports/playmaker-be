package com.example.playmaker.web.member.controller;

import com.example.playmaker.security.PrincipalUserDetails;
import com.example.playmaker.service.member.MemberService;
import com.example.playmaker.web.member.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody MemberForm memberForm) {
        memberService.join(memberForm);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfo> login(@Valid @RequestBody LoginForm loginForm) {
        return new ResponseEntity<>(memberService.login(loginForm), HttpStatus.OK);
    }

    @GetMapping("/mypage")
    public ResponseEntity<MyPageInfo> showMyPage(@AuthenticationPrincipal PrincipalUserDetails principalUserDetails) {
        Long loginMemberId = principalUserDetails.getMember().getId();
        return new ResponseEntity<>(memberService.showMyPage(loginMemberId), HttpStatus.OK);
    }

    @PostMapping("/mypage")
    public ResponseEntity<?> updateMyPage(@AuthenticationPrincipal PrincipalUserDetails principalUserDetails, @RequestBody MyPageForm myPageForm) {
        Long loginMemberId = principalUserDetails.getMember().getId();
        memberService.updateMyPage(loginMemberId, myPageForm);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
