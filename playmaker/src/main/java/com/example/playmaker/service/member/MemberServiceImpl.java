package com.example.playmaker.service.member;

import com.example.playmaker.code.ActiveArea;
import com.example.playmaker.code.Role;
import com.example.playmaker.domain.member.Member;
import com.example.playmaker.domain.member.MemberRepository;
import com.example.playmaker.exception.CustomException;
import com.example.playmaker.security.JwtTokenProvider;
import com.example.playmaker.web.member.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.playmaker.code.Error.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    @Override
    public Member join(MemberForm memberForm) {

        validateUsername(memberForm.getUsername()); // 아이디중복검증
        validateNickname(memberForm.getNickname()); // 닉네임중복검증
        validateEmail(memberForm.getEmail()); //이메일중복검증

        Member member = Member.builder()
                .username(memberForm.getUsername())
                .password(passwordEncoder.encode(memberForm.getPassword()))
                .nickname(memberForm.getNickname())
                .contact(memberForm.getContact())
                .birth(memberForm.getBirth())
                .sex(memberForm.getSex())
                .email(memberForm.getEmail())
                .position(memberForm.getPosition())
                .activeArea(memberForm.getActiveArea())
                .activeTime(memberForm.getActiveTime())
                .mercenaryYn("N")  //회원가입시 용병여부 디폴트값 N
                .proposalYn(memberForm.getProposalYn())
                .gameStyle(memberForm.getGameStyle())
                .selfIntro(memberForm.getSelfIntro())
                .preferredSoccerTeam(memberForm.getPreferredSoccerTeam())
                .pfUrl(memberForm.getPfUrl())
                .role(Role.ROLE_PLAYER) //최초가입시 일반 선수로 역할지정
                .build();
        return memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
    }

    @Transactional
    @Override
    public LoginInfo login(LoginForm loginForm) {
        Member member = memberRepository.findByUsername(loginForm.getUsername())
                .orElseThrow(() -> new CustomException(USER_NOT_FOUND));

        if (!passwordEncoder.matches(loginForm.getPassword(), member.getPassword())) {
            throw new CustomException(MISMATCH_PASSWORD);
        }

        return LoginInfo.builder()
                .username(member.getUsername())
                .nickname(member.getNickname())
                .token(jwtTokenProvider.generateToken(member.getId(), member.getUsername()))
                .build();
    }

    @Override
    public MyPageInfo showMyPage(Long id) {
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        return MyPageInfo.builder()
                .nickname(findMember.getNickname())
                .pfUrl(findMember.getPfUrl())
                .birth(findMember.getBirth())
                .email(findMember.getEmail())
                .contact(findMember.getContact())
                .position(findMember.getPosition())
                .gameStyle(findMember.getGameStyle())
                .selfIntro(findMember.getSelfIntro())
                .preferredSoccerTeam(findMember.getPreferredSoccerTeam())
                .activeArea(findMember.getActiveArea().getValue())
                .activeTime(findMember.getActiveTime().getValue())
                .proposalYn(findMember.getProposalYn())
                .build();
    }

    @Transactional
    @Override
    public void updateMyPage(Long id, MyPageForm myPageForm) {
        Member findMember = memberRepository.findById(id).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        findMember.setNickname(myPageForm.getNickname());
        findMember.setPfUrl(myPageForm.getPfUrl());
        findMember.setContact(myPageForm.getContact());
        findMember.setPosition(myPageForm.getPosition());
        findMember.setGameStyle(myPageForm.getGameStyle());
        findMember.setSelfIntro(myPageForm.getSelfIntro());
        findMember.setPreferredSoccerTeam(myPageForm.getPreferredSoccerTeam());
//        findMember.setActiveArea(ActiveArea.of(myPageForm.getActiveArea()));
//        findMember.setActiveTime();
        findMember.setProposalYn(myPageForm.getProposalYn());
    }

    private void validateUsername(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new CustomException(DUPLICATE_USERNAME);
        }
    }

    private void validateNickname(String nickname) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new CustomException(DUPLICATE_NICKNAME);
        }
    }

    private void validateEmail(String email) {
        if (memberRepository.existsByEmail(email)) {
            throw new CustomException(DUPLICATE_EMAIL);
        }
    }

}
