package com.example.playmaker.service.teamboard;


import com.example.playmaker.domain.team.Team;
import com.example.playmaker.domain.team.TeamRepository;
import com.example.playmaker.domain.teamboard.TeamBoard;
import com.example.playmaker.domain.teamboard.TeamBoardRepository;
import com.example.playmaker.service.file.FileService;
import com.example.playmaker.service.team.TeamService;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamBoardServiceImpl implements TeamBoardService{
    private final TeamBoardRepository teamBoardRepository;
    private final FileService fileService;
    private final TeamRepository teamRepository;

    @Override
    public void insertBoard(BoardDto boardDto, MultipartFile file) throws IOException {
        String path = fileService.fileUpload(file);
        Team team =  teamRepository.findById(boardDto.getTeamId()).orElse(null);
        TeamBoard board = TeamBoard.builder()
                .boardName(boardDto.getBoardName())
                .userName(boardDto.getUserName())
                .makeDt(boardDto.getMakeDt())
                .email(boardDto.getEmail())
                .picUrl(path)
                .teamId(team)
                .build();
        teamBoardRepository.save(board);
    }

    @Override
    public List<BoardDto> selectAll() {
        List<TeamBoard> boardInfo = teamBoardRepository.findAll();
        List<BoardDto> info = boardInfo.stream()
                .map(o->new BoardDto())
                .sorted(Comparator.comparing(BoardDto::getMakeDt).reversed())
                .collect(Collectors.toList());
        return info;

    }
}
