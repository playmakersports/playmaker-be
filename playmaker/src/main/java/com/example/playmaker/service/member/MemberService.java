package com.example.playmaker.service.member;


import com.example.playmaker.domain.member.Member;
import com.example.playmaker.web.member.dto.LoginForm;
import com.example.playmaker.web.member.dto.LoginInfo;
import com.example.playmaker.web.member.dto.MemberForm;
import com.example.playmaker.web.member.dto.MyPageInfo;

public interface MemberService {

    Member join(MemberForm memberForm);
    LoginInfo login(LoginForm loginForm);
    MyPageInfo showMyPage(Long id);
    Member findMember(Long id);
}
