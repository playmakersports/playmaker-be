package com.example.playmaker.service.recruitspc;

import com.example.playmaker.code.Error;
import com.example.playmaker.domain.member.Member;
import com.example.playmaker.domain.member.MemberRepository;
import com.example.playmaker.domain.recruitboard.RecruitBoard;
import com.example.playmaker.domain.recruitboard.RecruitBoardRepository;
import com.example.playmaker.domain.recruitspc.RecruitSpc;
import com.example.playmaker.domain.recruitspc.RecruitSpcRepository;
import com.example.playmaker.exception.CustomException;
import com.example.playmaker.web.recruitspc.dto.RecruitSpcDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecruitSpcServiceImpl implements RecruitSpcService{
    private final RecruitBoardRepository recruitBoardRepository;
    private final MemberRepository memberRepository;
    private final RecruitSpcRepository recruitSpcRepository;
    @Override
    public void insertRecruitSpc(RecruitSpcDto recruitSpcDto) {
        RecruitBoard board = recruitBoardRepository.findById(recruitSpcDto.getRecruitBoard()).orElseThrow(() -> new CustomException(Error.BOARD_NOT_FOUND));
        Member member = memberRepository.findById(recruitSpcDto.getMemberId()).orElseThrow(() -> new CustomException(Error.USER_NOT_FOUND));
        RecruitSpc recruitSpc = RecruitSpc.builder()
                .join_yn(recruitSpcDto.getJoinYn())
                .recruitBoard(board)
                .memberId(member)
                .build();
        recruitSpcRepository.save(recruitSpc);
    }

    @Override
    public List<RecruitSpcDto> selectAll() {
        List<RecruitSpc> recruitSpcInfo = recruitSpcRepository.findAll();
        List<RecruitSpcDto> info = recruitSpcInfo.stream()
                .map(o->new RecruitSpcDto())
                .collect(Collectors.toList());
        return info;
    }
}
