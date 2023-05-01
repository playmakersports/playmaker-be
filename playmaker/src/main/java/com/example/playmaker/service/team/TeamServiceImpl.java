package com.example.playmaker.service.team;

import com.example.playmaker.domain.team.Team;
import com.example.playmaker.domain.team.TeamRepository;
import com.example.playmaker.service.file.FileService;
import com.example.playmaker.web.team.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;
    private final FileService fileService;

    @Override
    public void insertTeam(TeamDto teamDto, MultipartFile file) throws IOException {
        String path = fileService.fileUpload(file);
        Team team = Team.builder()
                .teamName(teamDto.getTeamName())
                .engName(teamDto.getEngName())
                .teamColor(teamDto.getTeamColor())
                .item(teamDto.getItem())
                .activeArea(teamDto.getActiveArea())
                .logoUrl(path)
                .teamIntro(teamDto.getTeamIntro())
                .joinYn(teamDto.getJoinYn())
                .message(teamDto.getMessage())
                .build();
        teamRepository.save(team);
    }

    @Override
    public List<TeamDto> selectAll() {
        List<Team> teamInfo = teamRepository.findAll();
        List<TeamDto> info = teamInfo.stream()
                .map(o -> new TeamDto())
                .sorted(Comparator.comparing(TeamDto::getCreate_dt).reversed())
                .collect(Collectors.toList());
        return info;
    }
}
