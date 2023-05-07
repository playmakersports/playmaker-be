package com.example.playmaker.service.member;


import com.example.playmaker.domain.member.Member;
import com.example.playmaker.web.member.dto.*;

public interface MemberService {

    Member join(MemberForm memberForm);
    LoginInfo login(LoginForm loginForm);
    MyPageInfo showMyPage(Long id);
    void updateMyPage(Long id, MyPageForm myPageForm);
    Member findMember(Long id);
}
