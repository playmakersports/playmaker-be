package com.example.playmaker.web.member.controller;

import com.example.playmaker.domain.member.Member;
import com.example.playmaker.security.PrincipalUserDetails;
import com.example.playmaker.service.member.MemberService;
import com.example.playmaker.web.member.dto.LoginForm;
import com.example.playmaker.web.member.dto.LoginInfo;
import com.example.playmaker.web.member.dto.MemberForm;
import com.example.playmaker.web.member.dto.MyPageInfo;
import lombok.Data;
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
    public ResponseEntity<?> showMyPage() {
//        Long memberId = principalUserDetails.getMember().getId();
//        return new ResponseEntity<>(memberService.showMyPage(memberId), HttpStatus.OK);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
