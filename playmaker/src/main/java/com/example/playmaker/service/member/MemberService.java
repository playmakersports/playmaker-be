package com.example.playmaker.service.member;


import com.example.playmaker.domain.member.Member;
import com.example.playmaker.web.member.dto.MemberForm;

public interface MemberService {

    Member join(MemberForm memberForm);
    Member findMember(Long id);
}
