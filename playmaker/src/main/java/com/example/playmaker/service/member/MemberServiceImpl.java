package com.example.playmaker.service.member;

import com.example.playmaker.code.Error;
import com.example.playmaker.domain.member.Member;
import com.example.playmaker.domain.member.MemberRepository;
import com.example.playmaker.exception.CustomException;
import com.example.playmaker.web.member.dto.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member join(MemberForm memberForm) {
        Member member = Member.builder()
                .username(memberForm.getUsername())
                .password(passwordEncoder.encode(memberForm.getPassword()))
                .nickname(memberForm.getNickname())
                .contact(memberForm.getContact())
                .birth(memberForm.getBirth())
                .build();
        return memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new CustomException(Error.USER_NOT_FOUND));
    }
}
