package com.example.playmaker.service.match;

import com.example.playmaker.code.Error;
import com.example.playmaker.domain.match.Match;
import com.example.playmaker.domain.match.MatchRepository;
import com.example.playmaker.domain.member.Member;
import com.example.playmaker.domain.member.MemberRepository;
import com.example.playmaker.domain.team.Team;
import com.example.playmaker.exception.CustomException;
import com.example.playmaker.web.match.dto.MatchForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.playmaker.code.Error.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MatchServiceImpl implements MatchService{

    private final MatchRepository matchRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Match createMatch(Long id, MatchForm matchForm) {
        Member loginMember = memberRepository.findById(id).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        Team homeTeam = loginMember.getTeam();
        Match match = Match.builder()
                .homeTeam(homeTeam)
                .matchDt(matchForm.getMatchDt())
                .matchArea(matchForm.getMatchArea())
                .publicMatchYn(matchForm.getPublicMatchYn())
                //.prgStatusCode()
                //.resultCode()
                //.homeTeamPlayerRegisterYn()
                .build();
        return matchRepository.save(match);
    }
}
