package com.example.playmaker.web.member.controller;

import com.example.playmaker.domain.teamoffer.TeamOffer;
import com.example.playmaker.security.PrincipalUserDetails;
import com.example.playmaker.service.member.MemberService;
import com.example.playmaker.service.teamoffer.TeamOfferService;
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
    private final TeamOfferService teamOfferService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody MemberForm memberForm) {
        memberService.join(memberForm);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginInfo> login(@Valid @RequestBody LoginForm loginForm) {
        return new ResponseEntity<>(memberService.login(loginForm), HttpStatus.OK);   //jwt 내부 id, username, role 들어감
    }


    //UserPage 쪽은 로그인자의 id와 userPage 주인의 id를 구분해야함
    //로그인자의 id는 jwt 안에 포함되있음.
    //userPage 주인의 id는 pathVariable 임

    @GetMapping("/userPage/{memberId}")
    public ResponseEntity<UserPageInfo> showUserPage(@PathVariable Long memberId) {
        return new ResponseEntity<>(memberService.showUserPage(memberId), HttpStatus.OK);
    }

    @GetMapping("/userPage/{memberId}/edit")
    public ResponseEntity<UserPageInfo> showEditUserPage(@PathVariable Long memberId) {
        return new ResponseEntity<>(memberService.showUserPage(memberId), HttpStatus.OK);
    }

    @PostMapping("/userPage/{memberId}/edit")
    public ResponseEntity<?> updateEditUserPage(@RequestBody UserPageForm userPageForm, @PathVariable Long memberId) {
        memberService.updateUserPage(memberId, userPageForm);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/userPage/{memberId}/offer")
    public ResponseEntity<?> showOfferPage(@AuthenticationPrincipal PrincipalUserDetails principalUserDetails, @PathVariable Long memberId,
                                           @RequestBody OfferForm offerForm) {

        Long loginMemberId = principalUserDetails.getMember().getId();
        teamOfferService.offer(loginMemberId, memberId, offerForm);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
