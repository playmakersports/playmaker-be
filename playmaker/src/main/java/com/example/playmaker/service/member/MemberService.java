package com.example.playmaker.service.member;


import com.example.playmaker.domain.member.Member;
import com.example.playmaker.domain.teamoffer.TeamOffer;
import com.example.playmaker.web.member.dto.*;

public interface MemberService {

    Member join(MemberForm memberForm);
    LoginInfo login(LoginForm loginForm);
    UserPageInfo showUserPage(Long id);
    void updateUserPage(Long id, UserPageForm userPageForm);
    Member findMember(Long id);
}
